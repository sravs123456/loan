package com.neoteric.fullstackdemo_310824.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
    @Table(name = "account",schema = "bank")
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class AccountEntity {
        @Column(name = "name",nullable = false)
        private String name;
        @Id
        @Column(name = "accountnumber",nullable = false)
        private String accountNumber;
        @Column(name = "pan",nullable = false)
        private String pan;
        @Column(name = "mobile",nullable = false)
        private String mobileNumber;
        @Column(name = "balance",nullable = false)
        private double balance;
        @OneToMany(mappedBy = "accountEntity",cascade = CascadeType.ALL,orphanRemoval = true)
        public List<AccountAddressEntity> accountAddressEntities;


    }

