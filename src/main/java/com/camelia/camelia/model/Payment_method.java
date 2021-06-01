package com.camelia.camelia.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Payment_method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_payment_method;
    private String name;

}
