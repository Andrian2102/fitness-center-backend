package com.example.fitnesscenterservice.Controller;

import com.example.fitnesscenterservice.Mapper.InfoSubscriptionMapper;
import com.example.fitnesscenterservice.Mapper.SubscriptionMapper;
import com.example.fitnesscenterservice.Model.Menu;
import com.example.fitnesscenterservice.Model.MessageModel;
import com.example.fitnesscenterservice.Model.Subscription;
import com.example.fitnesscenterservice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SubscriptionController {
    @Autowired
    SubscriptionMapper subscriptionMapper;
    @GetMapping("/menu")
    public MessageModel showAllMenu (){
        MessageModel msg = new MessageModel();
        try {
            List<Menu> menus = subscriptionMapper.getAllMenu();
            msg.setStatus(true);
            msg.setMessage("Data Retrieved");
            msg.setData(menus);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }

    @PostMapping("/subscribe")
    private MessageModel makeNewSubscription(@RequestBody Subscription subscription){
        MessageModel msg = new MessageModel();
        try {
            subscription.setStatus("Pending");
            subscriptionMapper.createNewSubscription(subscription);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }
}
