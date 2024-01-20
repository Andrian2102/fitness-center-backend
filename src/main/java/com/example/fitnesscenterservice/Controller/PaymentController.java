package com.example.fitnesscenterservice.Controller;

import com.example.fitnesscenterservice.Mapper.PaymentMapper;
import com.example.fitnesscenterservice.Mapper.SubscriptionMapper;
import com.example.fitnesscenterservice.Model.MessageModel;
import com.example.fitnesscenterservice.Model.Subscription;
import com.example.fitnesscenterservice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentController {
    @Autowired
    PaymentMapper paymentMapper;
    @Autowired
    SubscriptionMapper subscriptionMapper;
    @GetMapping("/payment-info")
    public MessageModel infoPayment (@RequestParam String subscriptionId){
        MessageModel msg = new MessageModel();
        try {
            Subscription subscription = paymentMapper.getPaymentInfo(subscriptionId);
            msg.setStatus(true);
            msg.setMessage("Return Data Success");
            msg.setData(subscription);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }

    @PutMapping("/payment-complete")
    public MessageModel paymentComplete (@RequestParam String status,
                                         @RequestParam String subscriptionId){
        MessageModel msg = new MessageModel();
        try {
            paymentMapper.updatePayment(subscriptionId, status);
            Subscription subscription = subscriptionMapper.getSubscription(subscriptionId);
            msg.setStatus(true);
            msg.setMessage("Return Data Success");
            msg.setData(subscription);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }
}
