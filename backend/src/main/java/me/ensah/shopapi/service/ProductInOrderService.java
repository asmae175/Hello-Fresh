package me.ensah.shopapi.service;

import me.ensah.shopapi.entity.ProductInOrder;
import me.ensah.shopapi.entity.User;


public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
