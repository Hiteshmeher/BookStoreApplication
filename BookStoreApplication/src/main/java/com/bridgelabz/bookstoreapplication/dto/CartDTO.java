package com.bridgelabz.bookstoreapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private int userId;
    private int bookId;
    @NotNull(message = "quantity should not be null")
    private int quantity;
}