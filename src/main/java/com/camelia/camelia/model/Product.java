package com.camelia.camelia.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;

    private String name;
    private String model;
    private String specification;
    private int stock;
    private double price;

    @OneToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category id_category;

    @OneToOne
    @JoinColumn(name = "id_provider", referencedColumnName = "id_provider")
    private Provider id_provider;

}
