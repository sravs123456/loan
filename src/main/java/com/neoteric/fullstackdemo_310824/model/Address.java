package com.neoteric.fullstackdemo_310824.model;

import lombok.Data;

@Data
public class Address {
    private String address1;
    private String address2;
    private String pincode;
    private String city;
    private String state;
}
