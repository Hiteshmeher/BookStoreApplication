package com.bridgelabz.bookstoreapplication.service;

import com.bridgelabz.bookstoreapplication.dto.OrderDTO;
import com.bridgelabz.bookstoreapplication.entity.OrderData;

import java.util.List;

public interface IOrderService {
    OrderData placeOrder(int userId, OrderDTO orderDto);
    String cancelOrder(int orderId, int userId);
    List<OrderData> userOrders(int userId);
}