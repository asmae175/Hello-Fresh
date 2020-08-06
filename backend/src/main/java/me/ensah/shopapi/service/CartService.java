package me.ensah.shopapi.service;

import me.ensah.shopapi.entity.Cart;
import me.ensah.shopapi.entity.ProductInOrder;
import me.ensah.shopapi.entity.User;

import java.util.Collection;


public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
