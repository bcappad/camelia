package com.camelia.camelia.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_provider;

    private String name;
    private String tradename;
    private String cuit;
    private String email;
    private String phone_number;
    private String whatsap;
    private String comments;
    private String address;
}
