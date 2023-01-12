package com.cabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long vehicleId;

    String regNo;

    Date regDate;

    String chasisNo;

    String Brand;

    String vehicleClass;

    String model;

    String fitnessUpto;

    String InsuranceUpto;

    String rcStatus;

    @OneToOne
    Driver driver;

    @OneToOne
    VehicleOwner vehicleOwner;

    @OneToMany
    List<Booking> bookingList = new ArrayList<>();
}