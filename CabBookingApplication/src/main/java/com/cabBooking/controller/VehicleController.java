package com.cabBooking.controller;

import com.cabBooking.model.Vehicle;
import com.cabBooking.serviceLayer.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicle), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> viewVehicle(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.viewVehicle(vehicleId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.deleteVehicle(vehicleId), HttpStatus.OK);
    }
}
