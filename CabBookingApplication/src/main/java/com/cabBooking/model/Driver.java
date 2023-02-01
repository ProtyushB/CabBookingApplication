package com.cabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long driverId;

    String name;

    String phone;

    String email;

    String password;

    String adhaarNumber;

    String bankAccountNumber;

    String licenseNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Vehicle vehicle;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Booking> allBookings = new ArrayList<>();
}
