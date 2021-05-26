package com.camelia.camelia.model;


import lombok.Data;


import javax.persistence.*;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_product;

    private String name;
    private String model;
    private String specification;

    //@Column(name="id_category")
    @OneToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category id_category;

   // @Column(name="id_provider")
    @OneToOne
    @JoinColumn(name = "id_provider", referencedColumnName = "id_provider")
    private Provider id_provider;

   /* @JsonBackReference
    @ManyToMany(mappedBy = "salesProduct")
    private Set<Product> products;
    */

    @ManyToOne
    @JoinColumn (name = "id_sales")
    private Sales sales;




}
