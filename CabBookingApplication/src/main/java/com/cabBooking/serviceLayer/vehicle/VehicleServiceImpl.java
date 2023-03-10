package com.cabBooking.serviceLayer.vehicle;

import com.cabBooking.dao.VehicleDao;
import com.cabBooking.model.Booking;
import com.cabBooking.model.Driver;
import com.cabBooking.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleDao vehicleDao;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        Vehicle vcl = vehicleDao.findVehicleByRegNo(vehicle.getRegNo());

        if (vcl==null) vcl = vehicleDao.save(vehicle);
        else {
            //Vehicle Already Exists
        }

        return vcl;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        Vehicle updatedVehicle = null;

        Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicle.getVehicleId());

        if (optionalVehicle.isPresent()) updatedVehicle = optionalVehicle.get();
        else {
            //Vehicle Not Found
        }
        return updatedVehicle;
    }

    @Override
    public Vehicle viewVehicle(Long vehicleId) {
        Vehicle vehicle = null;

        Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicleId);

        if (optionalVehicle.isPresent()) vehicle = optionalVehicle.get();
        else {
            //Vehicle Not Found
        }
        return vehicle;
    }

    @Override
    public String deleteVehicle(Long vehicleId) {

        Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicleId);

        if (optionalVehicle.isPresent()) vehicleDao.deleteById(vehicleId);
        else {
            //Vehicle Not Found
        }
        return "Vehicle Deleted Successfully";
    }





    @Override
    public List<Booking> getAllBookings(Long vehicleId) {
        Vehicle vehicle = null;
        List<Booking> allBookings = new ArrayList<>();

        Optional<Vehicle> optionalVehicle  = vehicleDao.findById(vehicleId);

        if (optionalVehicle.isPresent()){
            vehicle = optionalVehicle.get();
            allBookings = vehicle.getAllBookings();

            if (allBookings.size()==0) {/* No Bookings Found */}
        }
        else{
            //Vehicle Not Found
        }
        return allBookings;
    }

    @Override
    public List<Booking> getBookingHistory(Long vehicleId) {
        Vehicle vehicle = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> bookingHistory = new ArrayList<>();

        Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicleId);

        if (optionalVehicle.isPresent()){
            vehicle = optionalVehicle.get();
            allBookings = vehicle.getAllBookings();

            for (Booking b : allBookings)
                if (b.getBookingStatus().equals("Completed"))
                    bookingHistory.add(b);

            if (bookingHistory.size()==0) {/* No Booking History Found */}
        }
        else{
            //Vehicle Not Found
        }
        return bookingHistory;
    }

    @Override
    public List<Booking> getActiveBookings(Long vehicleId) {
        Vehicle vehicle = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> activeBookings = new ArrayList<>();

        Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicleId);

        if (optionalVehicle.isPresent()){
            vehicle = optionalVehicle.get();
            allBookings = vehicle.getAllBookings();

            for (Booking b : allBookings)
                if (b.getBookingStatus().equals("Active"))
                    activeBookings.add(b);

            if (activeBookings.size()==0) {/* Not Active Bookings Available */}
        }
        else {
            //Vehicle Not Found
        }
        return activeBookings;
    }

    @Override
    public List<Booking> getUpComingBookings(Long vehicleId) {
        Vehicle vehicle = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> upComingBookings = new ArrayList<>();

        Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicleId);

        if (optionalVehicle.isPresent()){
            vehicle = optionalVehicle.get();
            allBookings = vehicle.getAllBookings();

            for (Booking b : allBookings)
                if (b.getBookingStatus().equals("Upcoming"))
                    upComingBookings.add(b);

            if (upComingBookings.size()==0) {/* No UpComing Bookings Available */}
        }
        else {
            //Vehicle Not Found
        }
        return upComingBookings;
    }

    @Override
    public List<Booking> getCancelledBookings(Long vehicleId) {
        Vehicle vehicle = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> cancelledBookings = new ArrayList<>();

        Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicleId);

        if (optionalVehicle.isPresent()){
            vehicle = optionalVehicle.get();
            allBookings = vehicle.getAllBookings();

            for (Booking b : allBookings)
                if (b.getBookingStatus().equals("Cancelled"))
                    cancelledBookings.add(b);

            if (cancelledBookings.size()==0) {/* No Cancelled Bookings Available */}
        }
        else {
            //Vehicle Not Found
        }
        return cancelledBookings;
    }
}
