package com.cabBooking.serviceLayer.booking;

import com.cabBooking.model.Booking;

import java.awt.print.Book;

public interface BookingService {
    Booking addBooking(Booking booking);
    Booking updateBooking(Booking booking);
    Booking viewBooking(Long bookingId);
    String deleteBooking(Long bookingId);
}
