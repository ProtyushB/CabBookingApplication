package com.cabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long addressId;

    String apartmentNumber;

    String buildingName;

    String streeName;

    String coutry;

    String state;

    String city;

    String pincode;
}
