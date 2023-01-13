package com.cabBooking.controller;

import com.cabBooking.model.VehicleOwner;
import com.cabBooking.serviceLayer.vehicleOwner.VehicleOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicleOwner")
public class VehicleOwnerController {

    @Autowired
    private VehicleOwnerService vehicleOwnerService;

    @PostMapping("/")
    public ResponseEntity<VehicleOwner> addVehicleOwner(@RequestBody VehicleOwner vehicleOwner){
        return new ResponseEntity<>(vehicleOwnerService.addVehicleOwner(vehicleOwner), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<VehicleOwner> updateVehicleOwner(@RequestBody VehicleOwner vehicleOwner){
        return new ResponseEntity<>(vehicleOwnerService.updateVehicleOwner(vehicleOwner), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleOwner> getVehicleOwner(@PathVariable("id") Long vehicleOwnerId){
        return new ResponseEntity<>(vehicleOwnerService.viewVehicleOwner(vehicleOwnerId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicleOwner(@PathVariable("id") Long vehicleOwnerId){
        return new ResponseEntity<>(vehicleOwnerService.deleteVehicleOwner(vehicleOwnerId), HttpStatus.OK);
    }

}
