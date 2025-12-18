package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProfileDao;
import org.yearup.data.SalesOrderDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.data.UserDao;
import org.yearup.models.Profile;
import org.yearup.models.SalesOrder;
import org.yearup.models.ShoppingCart;
import org.yearup.models.User;

import java.security.Principal;

    @RestController
    @RequestMapping("orders") // URL stays "orders" to match the frontend/book requirements
    @CrossOrigin
    @PreAuthorize("isAuthenticated()")
    public class SalesController {

        private SalesOrderDao salesOrderDao;
        private UserDao userDao;
        private ProfileDao profileDao;
        private ShoppingCartDao shoppingCartDao;

        @Autowired
        public SalesController(SalesOrderDao salesOrderDao, UserDao userDao, ProfileDao profileDao, ShoppingCartDao shoppingCartDao) {
            this.salesOrderDao = salesOrderDao;
            this.userDao = userDao;
            this.profileDao = profileDao;
            this.shoppingCartDao = shoppingCartDao;
        }

        @PostMapping
        public SalesOrder checkout(Principal principal) {
            try {
                // 1. Identify User
                String username = principal.getName();
                User currentUser = userDao.getByUserName(username);
                int userId = currentUser.getId();

                // 2. Gather Data
                Profile profile = profileDao.getByUserId(userId);
                ShoppingCart cart = shoppingCartDao.getByUserId(userId);

                // Safety Check: Can't checkout an empty cart
                if(cart.getItems().isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cart is empty");
                }

                // 3. Process Order
                SalesOrder completedOrder = salesOrderDao.create(profile, cart);

                // 4. Cleanup
                shoppingCartDao.deleteFromCart(userId);

                return completedOrder;

            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Checkout failed");
            }
        }
}
