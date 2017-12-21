package com.betsegaw.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Embeddable
public class Address {

    private String phone;
    private String email;
    private String country;
    private String city;
    private String subCity;

    public Address() {
    }

    public Address(String phone, String email, String country, String city, String subCity) {
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.city = city;
        this.subCity = subCity;
    }
}
