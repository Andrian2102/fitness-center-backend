package com.example.fitnesscenterservice.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
@Getter
@Setter
public class Menu {
    private String menuId;
    private String namaSubscription;
    private BigInteger harga;
    private String jadwal;
    private Integer durasi;
}
