package com.example.fitnesscenterservice.Mapper;

import com.example.fitnesscenterservice.Model.CreditCard;
import com.example.fitnesscenterservice.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RegistrationMapper {
    String getEmail(String email);
    void insertDataUser(User user);
    String getStatus(String email);
    void insertDataKredit(CreditCard creditCard);
}
