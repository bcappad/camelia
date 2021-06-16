package com.camelia.camelia.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String user;
    private String password;
    private String name;
    private String last_name;

    @OneToOne
    @JoinColumn(name = "id_user_role", referencedColumnName = "id_user_role")
    private User_role id_user_role;

}