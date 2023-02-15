package com.cabBooking.serviceLayer.vehicleOwner;

import com.cabBooking.dao.VehicleOwnerDao;
import com.cabBooking.model.VehicleOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleOwnerServiceImpl implements VehicleOwnerService {

    @Autowired
    private VehicleOwnerDao vehicleOwnerDao;

    @Override
    public VehicleOwner addVehicleOwner(VehicleOwner vehicleOwner) {
        VehicleOwner vOwner = null;

        if (vehicleOwner.getEmail()!=null){
            vOwner = vehicleOwnerDao.findByEmail(vehicleOwner.getEmail()).get();

            if (vOwner==null){
                vOwner = vehicleOwnerDao.save(vehicleOwner);
            }
            else {
                //VehicleOwner With Email Already Exists
            }
        }

        return vOwner;
    }

    @Override
    public VehicleOwner updateVehicleOwner(VehicleOwner vehicleOwner) {
        VehicleOwner vOwner = null;

        Optional<VehicleOwner> optionalVehicleOwner = vehicleOwnerDao.findById(vehicleOwner.getVehicleOwnerId());

        if (optionalVehicleOwner.isPresent()) vOwner = optionalVehicleOwner.get();
        else {
            //VehicleOwner Not Exists
        }
        return vOwner;
    }

    @Override
    public VehicleOwner viewVehicleOwner(Long vehicleOwnerId) {
        VehicleOwner vehicleOwner = null;

        Optional<VehicleOwner> optionalVehicleOwner = vehicleOwnerDao.findById(vehicleOwnerId);

        if (optionalVehicleOwner.isPresent()) vehicleOwner = optionalVehicleOwner.get();
        else {
            //VehicleOwner Not Exists
        }
        return vehicleOwner;
    }

    @Override
    public String deleteVehicleOwner(Long vehicleOwnerId) {

        Optional<VehicleOwner> optionalVehicleOwner = vehicleOwnerDao.findById(vehicleOwnerId);

        if (optionalVehicleOwner.isPresent()) vehicleOwnerDao.deleteById(vehicleOwnerId);
        else {
            //VehicleOwner Not Exists
        }
        return "VehicleOwner Deleted Successfully";
    }
}
