package com.cabBooking.controller;

import com.cabBooking.model.Driver;
import com.cabBooking.serviceLayer.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver){
        return new ResponseEntity<>(driverService.addDriver(driver), HttpStatus.CREATED);
    }

    @PutExchange("/")
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver){
        return new ResponseEntity<>(driverService.updateDriver(driver), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.viewDriver(driverId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable("id") Long driverId){
        return new ResponseEntity<>(driverService.deleteDriver(driverId), HttpStatus.OK);
    }
}
