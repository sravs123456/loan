package com.neoteric.fullstackdemo_310824.model;

import jakarta.persistence.*;
import lombok.Data;

@Data

public class AccountAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="address1")
    private String address1;
    @Column(name="address2")
    private String address2;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="pincode")
    private String pincode;
    @Column(name="status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountnumber",referencedColumnName = "accountnumber")
    private AccountEntity accountEntity;
}
