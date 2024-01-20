package com.example.fitnesscenterservice.Mapper;

import com.example.fitnesscenterservice.Model.Menu;
import com.example.fitnesscenterservice.Model.Subscription;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubscriptionMapper {
    List<Menu> getAllMenu();
    void createNewSubscription(Subscription subscription);
    Subscription getSubscription(String subscriptionId);
}
