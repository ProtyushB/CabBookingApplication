package com.cabBooking.serviceLayer.driver;

import com.cabBooking.dao.DriverDao;
import com.cabBooking.model.Booking;
import com.cabBooking.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
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

    /*@Override
    public String acceptBooking(Booking booking, Long driverId) {

    }

    @Override
    public String rejectBooking(Booking booking, Long driverId) {
        return null;
    }*/

    @Override
    public List<Booking> getAllBookings(Long driverId) {
        Driver driver = null;
        List<Booking> allBookings = new ArrayList<>();

        Optional<Driver> optionalDriver = driverDao.findById(driverId);

        if (optionalDriver.isPresent()){
            driver = optionalDriver.get();
            allBookings = driver.getAllBookings();

            if (allBookings.size()==0) {/* No Bookings Found */}
        }
        else {
            //Driver Not Found
        }
        return allBookings;
    }

    @Override
    public List<Booking> getBookingHistory(Long driverId) {
        Driver driver = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> bookingHistory = new ArrayList<>();

        Optional<Driver> optionalDriver = driverDao.findById(driverId);

        if (optionalDriver.isPresent()){
            driver = optionalDriver.get();
            allBookings = driver.getAllBookings();

            for (Booking b : allBookings)
                if(b.getBookingStatus().equals("Completed"))
                    bookingHistory.add(b);

            if (bookingHistory.size()==0) {/* Not Booking History Available */}
        }
        else{
            //Driver Not Found
        }
        return bookingHistory;
    }

    @Override
    public List<Booking> getActiveBookings(Long driverId) {
        Driver driver = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> activeBookings = new ArrayList<>();

        Optional<Driver> optionalDriver = driverDao.findById(driverId);

        if (optionalDriver.isPresent()){
            driver = optionalDriver.get();
            allBookings = driver.getAllBookings();

            for (Booking b : allBookings)
                if (b.getBookingStatus().equals("Active"))
                    activeBookings.add(b);

            if (activeBookings.size()==0) {/* No Active Bookings Available */}
        }
        else{
            //Driver Not Found
        }
        return activeBookings;
    }

    @Override
    public List<Booking> getUpComingBookings(Long driverId) {
        Driver driver = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> upComingBookings = new ArrayList<>();

        Optional<Driver> optionalDriver = driverDao.findById(driverId);

        if (optionalDriver.isPresent()){
            driver = optionalDriver.get();
            allBookings = driver.getAllBookings();

            for (Booking b : allBookings)
                if (b.getBookingStatus().equals("Upcoming"))
                    upComingBookings.add(b);
            if (upComingBookings.size()==0) {/* Not UpComing Bookings Available */}
        }
        else {
            //Driver Not Found
        }
        return upComingBookings;
    }

    @Override
    public List<Booking> getCancelledBookings(Long driverId) {
        Driver driver = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> cancelledBookings = new ArrayList<>();

        Optional<Driver> optionalDriver = driverDao.findById(driverId);

        if (optionalDriver.isPresent()){
            driver = optionalDriver.get();
            allBookings = driver.getAllBookings();

            for (Booking b : allBookings)
                if (b.getBookingStatus().equals("Cancelled"))
                    cancelledBookings.add(b);

            if (cancelledBookings.size()==0) {/* No Cancelled Bookings Available */}
        }
        else{
            //Driver Not Found
        }
        return cancelledBookings;
    }
}
