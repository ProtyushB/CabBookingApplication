package com.cabBooking.serviceLayer.location;

import com.cabBooking.dao.LocationDao;
import com.cabBooking.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationDao locationDao;

    @Override
    public Location addLocation(Location location) {
        return locationDao.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        Location lctn = null;

        Optional<Location> optionalLocation = locationDao.findById(location.getLocationId());

        if (optionalLocation.isPresent()) lctn = locationDao.save(location);
        else {
            //Location Not Found
        }
        return lctn;
    }

    @Override
    public Location viewLocation(Long locationId) {
        Location location = null;

        Optional<Location> optionalLocation = locationDao.findById(locationId);

        if (optionalLocation.isPresent()) location = optionalLocation.get();
        else {
            //Location Not Found
        }
        return location;
    }

    @Override
    public String deleteLocation(Long locationId) {
        Location location = null;

        Optional<Location> optionalLocation = locationDao.findById(locationId);

        if (optionalLocation.isPresent()) location = optionalLocation.get();
        else {
            //Location Not Found
        }
        return "Location Deleted Successfully";
    }
}
