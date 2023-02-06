package com.cabBooking.serviceLayer.vehicle;

import com.cabBooking.model.Booking;
import com.cabBooking.model.Driver;
import com.cabBooking.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    Vehicle viewVehicle(Long vehicleId);
    String deleteVehicle(Long vehicleId);

    Vehicle assignDriverToVehicle(Long vehicleId, Driver driver);
    Vehicle removeDriverFromVehicle(Long vehicleId, Long driverId);

    List<Booking> getAllBookings(Long vehicleId);
    List<Booking> getBookingHistory(Long vehicleId);
    List<Booking> getActiveBookings(Long vehicleId);
    List<Booking> getUpComingBookings(Long vehicleId);
    List<Booking> getCancelledBookings(Long vehicleId);
}
