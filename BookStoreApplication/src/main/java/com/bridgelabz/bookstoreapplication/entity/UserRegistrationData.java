package com.bridgelabz.bookstoreapplication.entity;

import com.bridgelabz.bookstoreapplication.dto.UserRegistrationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserData")
public class UserRegistrationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;

    public UserRegistrationData(UserRegistrationDTO userRegistrationDTO) {
        this.firstName = userRegistrationDTO.getFirstName();
        this.lastName = userRegistrationDTO.getLastName();
        this.email = userRegistrationDTO.getEmail();
        this.address = userRegistrationDTO.getAddress();
        this.password = userRegistrationDTO.getPassword();
    }

}
