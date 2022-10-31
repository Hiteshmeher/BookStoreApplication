package com.bridgelabz.bookstoreapplication.repository;

import com.bridgelabz.bookstoreapplication.entity.UserRegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationData,Integer> {
    @Query(value = "select * from user_data WHERE email= :Email", nativeQuery = true)
    UserRegistrationData findByEmail(String Email);
}