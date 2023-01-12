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

    @OneToOne(cascade = CascadeType.ALL)
    Address address;

    @OneToOne(cascade = CascadeType.ALL)
    Vehicle vehicle;

    @OneToMany
    List<Booking> bookingList = new ArrayList<>();
}
