package com.cabBooking.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bookingId;

    Short distance;

    Float price;

    LocalDateTime bookingTimeAndDate;

    LocalDateTime rideStartingTimeAndDate;

    LocalDateTime rideEndingTimeAndDate;

    Date date;

    @OneToOne
    Customer customer;

    @OneToOne
    Driver driver;
}
