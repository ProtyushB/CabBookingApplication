package com.cabBooking.serviceLayer.booking;

import com.cabBooking.model.Booking;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    Booking addBooking(Booking booking);
    Booking updateBooking(Booking booking);
    Booking viewBooking(Long bookingId);
    String deleteBooking(Long bookingId);

    List<Booking> getAllBookings();
    List<Booking> getAllBookingsByBookingStatus(String status);
}
