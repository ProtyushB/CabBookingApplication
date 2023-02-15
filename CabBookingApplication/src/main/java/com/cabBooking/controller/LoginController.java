package com.cabBooking.controller;

import com.cabBooking.dao.CustomerDao;
import com.cabBooking.dao.DriverDao;
import com.cabBooking.dao.VehicleOwnerDao;
import com.cabBooking.model.Customer;
import com.cabBooking.model.Driver;
import com.cabBooking.model.VehicleOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private DriverDao driverDao;

    @Autowired
    private VehicleOwnerDao vehicleOwnerDao;

    @GetMapping("/signIn")
    public ResponseEntity<Object> getLoggedInCustomerDetailsHandler(Authentication auth){
        System.out.println(auth);
        Customer customer = null;
        Driver driver = null;
        VehicleOwner vehicleOwner = null;

        Optional<Customer> optionalCustomer = customerDao.findByEmail(auth.getName());
        Optional<Driver> optionalDriver = driverDao.findByEmail(auth.getName());
        Optional<VehicleOwner> optionalVehicleOwner = vehicleOwnerDao.findByEmail(auth.getName());

        if (optionalCustomer.isPresent()){
            System.out.println("Inside Customer Login");
            customer = optionalCustomer.get();
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);

        }
        else if(optionalDriver.isPresent()){
            System.out.println("Inside Driver Login");
            driver = optionalDriver.get();
            return new ResponseEntity<>(driver, HttpStatus.ACCEPTED);
        }
        else if (optionalVehicleOwner.isPresent()){
            System.out.println("Inside Vehicle Owner Login");
            vehicleOwner = optionalVehicleOwner.get();
            return new ResponseEntity<>(vehicleOwner, HttpStatus.ACCEPTED);
        }
        else throw new BadCredentialsException("User Not Authorized");


        //to get the token in body, pass HttpServletResponse inside this method parameter
        // System.out.println(response.getHeaders(SecurityConstants.JWT_HEADER));

    }
}
