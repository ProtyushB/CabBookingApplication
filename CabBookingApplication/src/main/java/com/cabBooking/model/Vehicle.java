package com.cabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
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

    @OneToOne(fetch = FetchType.EAGER)
    Driver driver;

    /*@OneToOne(fetch = FetchType.LAZY)
    VehicleOwner vehicleOwner;*/

    @NotNull
    Long vehicleOwnerId;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Booking> bookingList = new ArrayList<>();
}
