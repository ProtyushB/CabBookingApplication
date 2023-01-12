package com.cabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long vehicleOwnerId;

    String name;

    String phone;

    String email;

    String password;

    Byte age;

    String gender;

    String adhaarNumber;

    String bankAccountNumber;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToMany
    List<Vehicle> vehicleList = new ArrayList<>();
}
