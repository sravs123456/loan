package com.neoteric.fullstackdemo_310824.model;

import lombok.Data;

import java.util.Date;

public class Atm {
    private String cardNumber;

    private String pin;

    private String accountNumber;

    private String cvv;

    private Date cardExpiry;
}
