package com.example.fitnesscenterservice.Controller;

import com.example.fitnesscenterservice.Mapper.AuthenticationMapper;
import com.example.fitnesscenterservice.Mapper.RegistrationMapper;
import com.example.fitnesscenterservice.Model.CreditCard;
import com.example.fitnesscenterservice.Model.MessageModel;
import com.example.fitnesscenterservice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegistrationController {

    @Autowired
    RegistrationMapper registrationMapper;
    @PostMapping("/create-account")
    public MessageModel createAccount (@RequestBody User user) {
        MessageModel msg = new MessageModel();
        try {
            if(user.getPassword().length()<8){
                msg.setStatus(false);
                msg.setMessage("Password tidak boleh kurang dari 8 karakter");
                return msg;
            }
            if (registrationMapper.getEmail(user.getEmail()) != null){
                msg.setStatus(false);
                msg.setMessage("Email telah terpakai. Mohon menggunakan email lain");
                return msg;
            }
            user.setUserId(UUID.randomUUID().toString());
            user.setStatus("Belum Tervalidasi");
            registrationMapper.insertDataUser(user);
            msg.setStatus(true);
            msg.setMessage("Data telah masuk menunggu otp");
            msg.setData(user.getEmail());
        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }

    @PostMapping("/create-credit")
    public MessageModel createCreditCard (@RequestBody CreditCard creditCard) {
        MessageModel msg = new MessageModel();
        try {
            creditCard.setCreditCardId(UUID.randomUUID().toString());
            registrationMapper.insertDataKredit(creditCard);
            msg.setStatus(true);
            msg.setMessage("Data telah masuk menunggu otp");
            msg.setData(creditCard.getUserId());
        } catch (Exception e) {
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }
    @GetMapping("/check-status")
    public MessageModel checkStatus (@RequestParam String email){
        MessageModel msg = new MessageModel();
        try {
            String statusEmailUser = registrationMapper.getStatus(email);
            msg.setStatus(true);
            msg.setMessage("Status Account anda: " + statusEmailUser);
        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }
}
