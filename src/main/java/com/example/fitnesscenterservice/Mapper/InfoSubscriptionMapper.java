package com.example.fitnesscenterservice.Mapper;

import com.example.fitnesscenterservice.Model.CreditCard;
import com.example.fitnesscenterservice.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InfoSubscriptionMapper {
    void updateDataUser(User user);
    void updateDataKredit(CreditCard creditCard);
    User getDataUser(String userId);
    CreditCard getCreditCard(String creditCardId);
}
