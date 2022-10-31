package com.bridgelabz.bookstoreapplication.entity;

import com.bridgelabz.bookstoreapplication.dto.CartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CartData")
public class CartData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserRegistrationData user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookData book;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total_price")
    private int totalPrice;


    public CartData(UserRegistrationData user , BookData book, int cartPrice, CartDTO cartDto) {
        this.user = user;
        this.book = book;
        this.quantity = cartDto.getQuantity();
        this.totalPrice = cartPrice;
    }
}