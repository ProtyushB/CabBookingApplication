package com.cabBooking.serviceLayer.driver;

import com.cabBooking.model.Booking;
import com.cabBooking.model.Driver;

import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);
    Driver updateDriver(Driver driver);
    Driver viewDriver(Long driverId);
    String deleteDriver(Long driverId);

    String acceptBooking(Booking booking);
    String rejectBooking(Booking booking);

    List<Booking> getAllBookings(Long driverId);
    List<Booking> getBookingHistory(Long driverId);
    List<Booking> getActiveBookings(Long driverId);
    List<Booking> getCencelledBookings(Long driverId);
}
