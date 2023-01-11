package com.cabBooking.serviceLayer.address;

import com.cabBooking.dao.AddressDao;
import com.cabBooking.model.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public Address addAddress(Address address) {
        Address add = addressDao.findAddressByAllDetails(address.getCoutry(), address.getState(), address.getCity(), address.getPincode(), address.getStreetName(), address.getBuildingName(), address.getApartmentNumber());

        if (add==null){
            add = addressDao.save(address);
        }
        /*else{
            //Address Already Exists
        }*/
        return add;
    }

    @Override
    public Address updateAddress(Address address) {
        Address add = null;

        Optional<Address> optionalAddress = addressDao.findById(address.getAddressId());

        if (optionalAddress.isPresent()) add = optionalAddress.get();
        else{
            //Address Not Exists
        }
        return add;
    }

    @Override
    public Address viewAddress(Long addressId) {
        Address add = null;

        Optional<Address> optionalAddress = addressDao.findById(addressId);

        if (optionalAddress.isPresent()) add = optionalAddress.get();
        else{
            //Address Not Found
        }
        return add;
    }

    @Override
    public String deleteAddress(Long addressId) {

        Optional<Address> optionalAddress = addressDao.findById(addressId);

        if (optionalAddress.isPresent()) addressDao.deleteById(addressId);
        else{
            //Address Not Exists
        }
        return "Address Deleted Successfully";
    }
}
