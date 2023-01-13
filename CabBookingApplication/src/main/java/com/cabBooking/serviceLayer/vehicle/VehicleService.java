package com.cabBooking.serviceLayer.vehicle;

import com.cabBooking.model.Vehicle;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    Vehicle viewVehicle(Long vehicleId);
    String deleteVehicle(Long vehicleId);
}
