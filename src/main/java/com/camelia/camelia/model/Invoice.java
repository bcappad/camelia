package com.camelia.camelia.model;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_invoice;

    private Date transaction_date;
    private String observation;
    private double final_amount;

    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User id_user;

    @OneToOne
    @JoinColumn(name = "id_payment_method", referencedColumnName = "id_payment_method")
    private Payment_method id_payment_method;

}
