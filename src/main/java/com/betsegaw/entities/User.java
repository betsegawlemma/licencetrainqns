package com.betsegaw.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String phone;
    private String email;

    public User() {
    }

    public User(String userName, String password, String phone, String email) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}
