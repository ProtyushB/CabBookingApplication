package com.cabBooking.serviceLayer.driver;

import com.cabBooking.model.Driver;

public interface DriverService {
    Driver addDriver(Driver driver);
    Driver updateDriver(Driver driver);
    Driver viewDriver(Long driverId);
    String deleteDriver(Long driverId);
}
