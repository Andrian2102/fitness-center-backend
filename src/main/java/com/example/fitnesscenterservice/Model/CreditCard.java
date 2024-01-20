package com.example.fitnesscenterservice.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {
    private String creditCardId;
    private String userId;
    private String nomorKartu;
    private String cvv;
    private String expiredDate;
    private String namaPengguna;
}
