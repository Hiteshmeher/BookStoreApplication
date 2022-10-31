package com.bridgelabz.bookstoreapplication.service;


import com.bridgelabz.bookstoreapplication.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.dto.UserRegistrationDTO;
import com.bridgelabz.bookstoreapplication.entity.UserRegistrationData;

import java.util.List;
import java.util.Optional;

public interface IUserRegistrationService {
    String addRecord(UserRegistrationDTO addressDto);
    List<UserRegistrationData> findAll();
    UserRegistrationData FindById(int id);
    UserRegistrationData loginUser(LoginDTO loginDTO);
    String resetPassword(LoginDTO loginDTO);
    UserRegistrationData verifyUser(String token);
}