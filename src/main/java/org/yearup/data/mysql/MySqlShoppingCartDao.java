package org.yearup.data.mysql;

import org.yearup.data.ShoppingCartDao;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao {

    public MySqlShoppingCartDao(DataSource dataSource) {
        super(dataSource);
    }
    @Override
    public ShoppingCart getByUserId(int userId) {
        ShoppingCart cart = new ShoppingCart();

        // Joining products table to get item details (name, price) alongside quantity
        String query = "SELECT products.*, shopping_cart.quantity " +
                "FROM shopping_cart " +
                "JOIN products ON shopping_cart.product_id = products.product_id " +
                "WHERE shopping_cart.user_id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, userId);
            ResultSet row = preparedstatement.executeQuery();

            while (row.next()) {
                Product product = MySqlProductDao.mapRow(row);
                int quantity = row.getInt("quantity");

                ShoppingCartItem item = new ShoppingCartItem();
                item.setProduct(product);
                item.setQuantity(quantity);

                cart.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cart;
    }
    @Override
    public void addItemToCart(int userId, int productId, int quantity) {
        String query = "INSERT INTO shopping_cart (user_id, product_id, quantity) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + ?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, userId);
            preparedstatement.setInt(2, productId);
            preparedstatement.setInt(3, quantity);
            preparedstatement.setInt(4, quantity); // This adds to existing quantity

            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updateQuantity(int userId, int productId, int quantity) {
        String query = "UPDATE shopping_cart SET quantity = ? " +
                "WHERE user_id = ? AND product_id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, quantity);
            preparedstatement.setInt(2, userId);
            preparedstatement.setInt(3, productId);

            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteFromCart(int userId) {
        String query = "DELETE FROM shopping_cart WHERE user_id = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
