package com.bridgelabz.bookstoreapplication.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserRegistrationDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="first name pattern is invalid")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="first name pattern is invalid")
    private String lastName;
    @Email
    private String email;
    @NotBlank(message = "address should not be empty")
    private String address;
    private String password;
}