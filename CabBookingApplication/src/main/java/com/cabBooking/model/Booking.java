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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Location rideStartingPoint;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Location rideEndingPoint;

    String bookingStatus;       // 1.Active     2.Completed     3.Upcoming


}
