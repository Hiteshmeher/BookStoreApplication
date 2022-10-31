package com.bridgelabz.bookstoreapplication.service;


import com.bridgelabz.bookstoreapplication.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.entity.CartData;

import java.util.List;

public interface ICartService {
    CartData addToCart(int userId, CartDTO cartDto);
    String deleteById(int cartid);
    CartData changeCartQuantity(int userId, int cartId, CartDTO cartDto);
    List<CartData> findAll();
    List<CartData> getCartDetailsByUserId(int userId);
    CartData updateCart(int userId, int cartId, int qty);
}