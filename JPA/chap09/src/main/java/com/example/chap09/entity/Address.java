package com.example.chap09.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
