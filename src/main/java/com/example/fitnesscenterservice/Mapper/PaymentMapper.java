package com.example.fitnesscenterservice.Mapper;

import com.example.fitnesscenterservice.Model.Subscription;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PaymentMapper {
    Subscription getPaymentInfo(String subscriptionId);
    void updatePayment(String subscriptionId, String status);
}
