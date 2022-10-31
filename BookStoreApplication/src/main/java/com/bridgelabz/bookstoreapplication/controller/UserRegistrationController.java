package com.bridgelabz.bookstoreapplication.controller;


import com.bridgelabz.bookstoreapplication.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.dto.ResponseDTO;
import com.bridgelabz.bookstoreapplication.dto.UserRegistrationDTO;
import com.bridgelabz.bookstoreapplication.entity.UserRegistrationData;
import com.bridgelabz.bookstoreapplication.service.IUserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

    @Autowired
    IUserRegistrationService iUserRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<String> AddAddressDetails( @RequestBody UserRegistrationDTO userRegistrationDTO) {
        String token = iUserRegistrationService.addRecord(userRegistrationDTO);
        ResponseDTO respDTO = new ResponseDTO("Registration successful", token);
        return new ResponseEntity(respDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        UserRegistrationData response = iUserRegistrationService.loginUser(loginDTO);
        ResponseDTO responseDTO = new ResponseDTO("Login Successful", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/findAll")
    public ResponseEntity<ResponseDTO> findAllDetail() {
        List<UserRegistrationData> userList = iUserRegistrationService.findAll();
        ResponseDTO responseDTO = new ResponseDTO("All Users", userList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/get/{Id}")
    public ResponseEntity<ResponseDTO> FindById(@PathVariable int Id) {
        UserRegistrationData response = iUserRegistrationService.FindById(Id);
        ResponseDTO responseDto = new ResponseDTO("User details by id", response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @PostMapping("/resetPassword")
    public ResponseEntity<ResponseDTO> changePassword(@RequestBody LoginDTO loginDTO) {
        String response = iUserRegistrationService.resetPassword(loginDTO);
        ResponseDTO responseDTO = new ResponseDTO("Password successfully changed", response);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @GetMapping("/verify/{token}")
    public ResponseEntity<ResponseDTO> verifyUser(@PathVariable String token) {
        UserRegistrationData user =iUserRegistrationService.verifyUser(token);
        ResponseDTO responseDTO = new ResponseDTO("verified", user);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}