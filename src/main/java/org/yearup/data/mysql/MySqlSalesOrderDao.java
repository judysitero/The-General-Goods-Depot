package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.SalesOrderDao;
import org.yearup.models.Profile;
import org.yearup.models.SalesOrder;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;

@Component
public class MySqlSalesOrderDao extends MySqlDaoBase implements SalesOrderDao {

    public MySqlSalesOrderDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public SalesOrder create(Profile profile, ShoppingCart cart) {
        // 1. Create the Order in the database
        String orderSql = "INSERT INTO orders (user_id, date, address, city, state, zip, shipping_amount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, profile.getUserId());
            statement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(3, profile.getAddress());
            statement.setString(4, profile.getCity());
            statement.setString(5, profile.getState());
            statement.setString(6, profile.getZip());
            statement.setBigDecimal(7, BigDecimal.ZERO); // Free shipping for now

            statement.executeUpdate();

            // 2. Get the new Order ID
            int newOrderId = -1;

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                newOrderId = keys.getInt(1);
            }

            // 3. Move items from Cart to OrderLineItems
            // We loop through the cart items and insert them into the database
            String itemSql = "INSERT INTO order_line_items (order_id, product_id, sales_price, quantity, discount) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement itemStatement = connection.prepareStatement(itemSql);

            for (ShoppingCartItem cartItem : cart.getItems().values()) {
                itemStatement.setInt(1, newOrderId);
                itemStatement.setInt(2, cartItem.getProductId());
                itemStatement.setBigDecimal(3, cartItem.getProduct().getPrice());
                itemStatement.setInt(4, cartItem.getQuantity());
                itemStatement.setBigDecimal(5, BigDecimal.ZERO);

                itemStatement.addBatch();
            }
            itemStatement.executeBatch();

            // 4. Return the new Order object
            SalesOrder newOrder = new SalesOrder();
            newOrder.setOrderId(newOrderId);
            newOrder.setOrderDate(LocalDateTime.now());
            newOrder.setUserId(profile.getUserId());
            return newOrder;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
