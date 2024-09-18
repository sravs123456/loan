package com.neoteric.fullstackdemo_310824.model;


import lombok.Data;

@Data
public class Account {
    private String name;

    private String accountNumber;

    private String pan;

    private String mobileNum;

    private double balance;
    private Address address;


}
