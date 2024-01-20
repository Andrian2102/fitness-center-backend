package com.example.fitnesscenterservice.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class Subscription {
    private String userId;
    private String menuId;
    private String status;
    private String pertemuan;
}
