package com.cabBooking.serviceLayer.address;

import com.cabBooking.model.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    Address addAddress(Address address);
    Address updateAddress(Address address);
    Address viewAddress(Long addressId);
    String deleteAddress(Long addressId);
}
