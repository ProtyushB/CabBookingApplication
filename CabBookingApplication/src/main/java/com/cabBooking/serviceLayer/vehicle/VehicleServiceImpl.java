package com.cabBooking.serviceLayer.vehicle;

import com.cabBooking.dao.VehicleDao;
import com.cabBooking.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
