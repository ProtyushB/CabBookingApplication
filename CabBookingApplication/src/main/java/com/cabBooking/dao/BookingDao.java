package com.cabBooking.dao;

import com.cabBooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long> {

    @Query("from Booking where bookingStatus=?1")
    List<Booking> getAllBookingsByBookingStatus(String status);

}
