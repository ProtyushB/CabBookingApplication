package com.cabBooking.controller;

import com.cabBooking.model.Booking;
import com.cabBooking.model.Driver;
import com.cabBooking.serviceLayer.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver){
        driver.setPassword(passwordEncoder.encode(driver.getPassword()));
        return new ResponseEntity<>(driverService.addDriver(driver), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver){
        return new ResponseEntity<>(driverService.updateDriver(driver), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> viewDriver(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.viewDriver(driverId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.deleteDriver(driverId), HttpStatus.OK);
    }







    @GetMapping("/allBookings/{id}")
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.getAllBookings(driverId), HttpStatus.FOUND);
    }

    @GetMapping("/bookingHistory/{id}")
    public ResponseEntity<List<Booking>> getBookingsHistory(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.getBookingHistory(driverId), HttpStatus.FOUND);
    }

    @GetMapping("/activeBookings/{id}")
    public ResponseEntity<List<Booking>> getActiveBookings(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.getActiveBookings(driverId), HttpStatus.FOUND);
    }

    @GetMapping("/upComingBookings/{id}")
    public ResponseEntity<List<Booking>> getUpComingBookings(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.getUpComingBookings(driverId), HttpStatus.FOUND);
    }

    @GetMapping("/cancelledBookings/{id}")
    public ResponseEntity<List<Booking>> getCancelledBookings(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.getCancelledBookings(driverId), HttpStatus.FOUND);
    }

}
