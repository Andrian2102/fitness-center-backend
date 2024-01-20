package com.example.fitnesscenterservice.Controller;

import com.example.fitnesscenterservice.Mapper.AuthenticationMapper;
import com.example.fitnesscenterservice.Model.MessageModel;
import com.example.fitnesscenterservice.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {
    @Autowired
    AuthenticationMapper authenticationMapper;

    @GetMapping("/login")
    public MessageModel loginUser (@RequestParam String email,
                                   @RequestParam String password){
        MessageModel msg = new MessageModel();
        try {
            if(authenticationMapper.getDataUserLogin(email, password)!=null){
                User user = authenticationMapper.getDataUserLogin(email, password);
                msg.setStatus(true);
                msg.setMessage("Return Data Success");
                msg.setData(user.getUserId());
            }else {
                msg.setStatus(true);
                msg.setMessage("Data Tidak Ada");
            }

        } catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
        }
        return msg;
    }
}
