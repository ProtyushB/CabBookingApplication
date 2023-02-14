package com.cabBooking.controller;

import com.cabBooking.model.Booking;
import com.cabBooking.model.Vehicle;
import com.cabBooking.serviceLayer.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.List;

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





    @GetMapping("/allBookings/{id}")
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.getAllBookings(vehicleId), HttpStatus.FOUND);
    }

    @GetMapping("/bookingHistory/{id}")
    public ResponseEntity<List<Booking>> getBookingsHistory(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.getBookingHistory(vehicleId), HttpStatus.FOUND);
    }

    @GetMapping("/activeBookings/{id}")
    public ResponseEntity<List<Booking>> getActiveBookings(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.getActiveBookings(vehicleId), HttpStatus.FOUND);
    }

    @GetMapping("/upComingBookings/{id}")
    public ResponseEntity<List<Booking>> getUpComingBookings(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.getUpComingBookings(vehicleId), HttpStatus.FOUND);
    }

    @GetMapping("/cancelledBookings/{id}")
    public ResponseEntity<List<Booking>> getCancelledBookings(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.getCancelledBookings(vehicleId), HttpStatus.FOUND);
    }
}
