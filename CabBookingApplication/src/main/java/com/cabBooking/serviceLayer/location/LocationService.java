package com.cabBooking.serviceLayer.location;

import com.cabBooking.dao.LocationDao;
import com.cabBooking.model.Location;

public interface LocationService {
    Location addLocation(Location location);
    Location updateLocation(Location location);
    Location viewLocation(Long locationId);
    String deleteLocation(Long locationId);
}
