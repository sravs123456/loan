package com.neoteric.fullstackdemo_310824.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.util.List;

@Entity
@Table(name = "address",schema = "bank")
@Data
public class AddressEntity {

    public AddressEntity(){

    }
    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "state")
    public String state;


    public List<AddressEntity> addressEntityList;

}
