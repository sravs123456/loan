package com.neoteric.fullstackdemo_310824.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="adhar",schema = "bank")
public class AdharEntity {

    public AdharEntity() {

    }
    @Id
    @Column(name="adharnumber")
    public Integer adharNumber;

    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy ="myMappedbyTestEntity")
    public List<AddressEntity> addressEntityList;




}
