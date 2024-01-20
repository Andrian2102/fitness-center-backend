package com.example.fitnesscenterservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userId;
    private String nama;
    private String email;
    private String password;
    private String noHandphone;
    private String status;
    private List<Menu> menuList;
}
