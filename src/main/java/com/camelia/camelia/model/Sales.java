package com.camelia.camelia.model;

import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_sales;

    private Date date;
    private String specification;
    private boolean survey_agreement;
    private double final_amount;
    private double payment;
    private double vuelto;
    private double redondeo;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User id_user;

   /* @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "sales_product",
            joinColumns = @JoinColumn(name ="id_sales"),
            inverseJoinColumns = @JoinColumn(name = "id_product")
    )
    private Set<Product> salesProduct;
    */


    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private List<Product> products;


    @OneToOne
    @JoinColumn(name = "id_payment_method", referencedColumnName = "id_payment_method")
    private Payment_method id_payment_method;




}
