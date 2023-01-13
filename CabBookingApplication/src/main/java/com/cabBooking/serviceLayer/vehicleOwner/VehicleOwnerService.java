package com.cabBooking.serviceLayer.vehicleOwner;

import com.cabBooking.model.VehicleOwner;

public interface VehicleOwnerService {
    VehicleOwner addVehicleOwner(VehicleOwner vehicleOwner);
    VehicleOwner updateVehicleOwner(VehicleOwner vehicleOwner);
    VehicleOwner viewVehicleOwner(Long vehicleOwnerId);
    String deleteVehicleOwner(Long vehicleOwnerId);
}
