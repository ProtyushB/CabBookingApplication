package com.cabBooking.serviceLayer.driver;

import com.cabBooking.model.Booking;
import com.cabBooking.model.Driver;

import java.util.List;

public interface DriverService {
    Driver addDriver(Driver driver);
    Driver updateDriver(Driver driver);
    Driver viewDriver(Long driverId);
    String deleteDriver(Long driverId);

    /*String acceptBooking(Booking booking, Long driverId);
    String rejectBooking(Booking booking, Long driverId);*/

    List<Booking> getAllBookings(Long driverId);
    List<Booking> getBookingHistory(Long driverId);
    List<Booking> getActiveBookings(Long driverId);
    List<Booking> getUpComingBookings(Long driverId);
    List<Booking> getCancelledBookings(Long driverId);
}
