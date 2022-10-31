package com.bridgelabz.bookstoreapplication.service;


import com.bridgelabz.bookstoreapplication.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.dto.UserRegistrationDTO;
import com.bridgelabz.bookstoreapplication.entity.UserRegistrationData;
import com.bridgelabz.bookstoreapplication.repository.UserRegistrationRepository;
import com.bridgelabz.bookstoreapplication.util.EmailSenderService;
import com.bridgelabz.bookstoreapplication.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService implements IUserRegistrationService{
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;
    @Autowired
    private EmailSenderService mailService;
    @Autowired
    private TokenUtil util;


    @Override
    public String addRecord(UserRegistrationDTO userRegistrationDTO ) {
        UserRegistrationData user = new UserRegistrationData(userRegistrationDTO);
        userRegistrationRepository.save(user);
        String token = util.createToken(user.getId());
        mailService.sendEmail(user.getEmail(), "Account Created Successfully",user.toString());
        return token;
    }

    @Override
    public List<UserRegistrationData> findAll() {
        return userRegistrationRepository.findAll();
    }

    @Override
    public UserRegistrationData FindById(int id) {
        Optional<UserRegistrationData> user = userRegistrationRepository.findById(id);
        if(user.isPresent())
            return user.get();
        return null;
    }

    @Override
    public UserRegistrationData loginUser(LoginDTO loginDTO) {
        Optional<UserRegistrationData> userDetails = Optional.ofNullable(userRegistrationRepository.findByEmail(loginDTO.getEmail()));
        if (userDetails.isPresent()) {
            if (userDetails.get().getPassword().equals(loginDTO.getPassword())) {
                return userDetails.get();
            }
        }
        return null;
    }

    @Override
    public String resetPassword(LoginDTO loginDTO) {
        Optional<UserRegistrationData> userDetails = Optional.ofNullable(userRegistrationRepository.findByEmail(loginDTO.getEmail()));
        String password = loginDTO.getPassword();
        if(userDetails.isPresent()){
            userDetails.get().setPassword(password);
            mailService.sendEmail(userDetails.get().getEmail(), "Password Changed Successfully",userDetails.toString());
            return userDetails.toString();
        }
        return null;
    }

    @Override
    public UserRegistrationData verifyUser(String token) {
        int userid = util.decodeToken(token);
        Optional<UserRegistrationData> user = userRegistrationRepository.findById(userid);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

}