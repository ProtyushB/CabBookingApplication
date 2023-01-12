package com.cabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bookingId;

    Short distance;

    Float price;

    LocalDateTime bookingTimeAndDate;

    LocalDateTime rideStartingTimeAndDate;

    LocalDateTime rideEndingTimeAndDate;

    String bookingStatus;
}
