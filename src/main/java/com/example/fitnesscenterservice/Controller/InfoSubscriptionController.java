package com.example.fitnesscenterservice.Controller;

import com.example.fitnesscenterservice.Mapper.InfoSubscriptionMapper;
import com.example.fitnesscenterservice.Model.CreditCard;
import com.example.fitnesscenterservice.Model.InfoUser;
import com.example.fitnesscenterservice.Model.MessageModel;
import com.example.fitnesscenterservice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InfoSubscriptionController {
    @Autowired
    InfoSubscriptionMapper infoSubscriptionMapper;

    @PutMapping("/change-data")
    public MessageModel infoPayment (@RequestParam InfoUser infoUser){
        MessageModel msg = new MessageModel();
        try {
            if (infoUser.getUserId()!=null){
                User user = new User();
                user.setNama(infoUser.getName());
                user.setPassword(infoUser.getPassword());
                infoSubscriptionMapper.updateDataUser(user);
            }
            if (infoUser.getCreditCardId()!=null){
                CreditCard newCreditCard = new CreditCard();
                newCreditCard.setNamaPengguna(infoUser.getNamaPengguna());
                newCreditCard.setNomorKartu(infoUser.getNomorKartu());
                newCreditCard.setCvv(infoUser.getCvv());
                newCreditCard.setExpiredDate(infoUser.getExpiredDate());
                infoSubscriptionMapper.updateDataKredit(newCreditCard);
            }
            msg.setStatus(true);
            msg.setMessage("Data telah terupdate");
            msg.setData(infoUser);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }

    @GetMapping("/data-user")
    public MessageModel infoUser (@RequestParam String userId){
        MessageModel msg = new MessageModel();
        try {
            User user = infoSubscriptionMapper.getDataUser(userId);
            msg.setStatus(true);
            msg.setMessage("Return Data Success");
            msg.setData(user);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }

    @GetMapping("/credit-card")
    public MessageModel infoCreditCard (@RequestParam String creditCardId){
        MessageModel msg = new MessageModel();
        try {
            CreditCard creditCard = infoSubscriptionMapper.getCreditCard(creditCardId);
            msg.setStatus(true);
            msg.setMessage("Return Data Success");
            msg.setData(creditCard);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }
}
