package com.camelia.camelia.model;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sale;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    private Product id_product;

    @OneToOne
    @JoinColumn(name = "id_invoice", referencedColumnName = "id_invoice")
    private Invoice id_invoice;





}
