package com.cabBooking.serviceLayer.booking;

import com.cabBooking.dao.BookingDao;
import com.cabBooking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingDao.save(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        Booking updatedBooking = null;

        Optional<Booking> optionalBooking = bookingDao.findById(booking.getBookingId());

        if (optionalBooking.isPresent()) updatedBooking = optionalBooking.get();
        else{
            //Booking Not Found
        }
        return updatedBooking;
    }

    @Override
    public Booking viewBooking(Long bookingId) {
        Booking booking = null;

        Optional<Booking> optionalBooking = bookingDao.findById(bookingId);

        if (optionalBooking.isPresent()) booking = optionalBooking.get();
        else {
            //Booking Not Found
        }
        return booking;
    }

    @Override
    public String deleteBooking(Long bookingId) {

        Optional<Booking> optionalBooking = bookingDao.findById(bookingId);

        if (optionalBooking.isPresent()) bookingDao.deleteById(bookingId);
        else {
            //Booking Not Found
        }
        return "Booking Deleted Successfully";
    }
}
