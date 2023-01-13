package com.cabBooking.serviceLayer.driver;

import com.cabBooking.dao.DriverDao;
import com.cabBooking.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private DriverDao driverDao;

    @Override
    public Driver addDriver(Driver driver) {
        Driver drv = null;

        if (driver.getEmail()!=null){
            drv = driverDao.findDriverByEmail(driver.getEmail());

            if (drv==null){
                drv = driverDao.save(driver);
            }
            else {
                //Driver Already Exists
            }
        }

        if (driver.getPhone()!=null){
            drv = driverDao.findDriverByPhone(driver.getPhone());

            if (drv==null){
                drv = driverDao.save(driver);
            }
            else {
                //Driver Already Exists
            }
        }

        return drv;
    }

    @Override
    public Driver updateDriver(Driver driver) {
        Driver updatedDriver = null;

        Optional<Driver> optionalDriver = driverDao.findById(driver.getDriverId());

        if (optionalDriver.isPresent()) updatedDriver = optionalDriver.get();
        else {
            //Driver Not Exists
        }

        return updatedDriver;
    }

    @Override
    public Driver viewDriver(Long driverId) {
        Driver driver = null;

        Optional<Driver> optionalDriver = driverDao.findById(driverId);

        if (optionalDriver.isPresent()) driver = optionalDriver.get();
        else {
            //Driver Not Exists
        }
        return driver;
    }

    @Override
    public String deleteDriver(Long driverId) {

        Optional<Driver> optionalDriver = driverDao.findById(driverId);

        if (optionalDriver.isPresent()) driverDao.deleteById(driverId);
        else {
            //Driver Not Exists
        }
        return "Driver Deleted Successfully";
    }
}
