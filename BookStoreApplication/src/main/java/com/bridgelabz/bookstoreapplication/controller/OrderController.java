package com.bridgelabz.bookstoreapplication.controller;

import com.bridgelabz.bookstoreapplication.dto.OrderDTO;
import com.bridgelabz.bookstoreapplication.dto.ResponseDTO;
import com.bridgelabz.bookstoreapplication.entity.OrderData;
import com.bridgelabz.bookstoreapplication.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    @PostMapping("/placeOrder/{userId}")
    public ResponseEntity<ResponseDTO> placeOrder(@PathVariable int userId, @RequestBody OrderDTO orderDto) {
        OrderData order = iOrderService.placeOrder(userId,orderDto);
        ResponseDTO response= new ResponseDTO("Order Placed",  order.getId());
        return new ResponseEntity<> (response, HttpStatus.OK);
    }

    @GetMapping("/userOrder/{userId}")
    public ResponseEntity<ResponseDTO> getUserOrders(@PathVariable int userId){
        List<OrderData> userOrders = iOrderService.userOrders(userId);
        ResponseDTO response = new ResponseDTO("Order Details", userOrders);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PutMapping("/cancelOrder/{userId}/{orderId}")
    public ResponseEntity<ResponseDTO> cancelOrder(@PathVariable int orderId,@PathVariable int userId) {
        String order = iOrderService.cancelOrder(orderId,userId);
        ResponseDTO response= new ResponseDTO("Order Cancelled ",  order);
        return new ResponseEntity<> (response,HttpStatus.OK);
    }

}