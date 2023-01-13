package com.cabBooking.controller;

import com.cabBooking.model.Location;
import com.cabBooking.serviceLayer.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/")
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        return new ResponseEntity<>(locationService.addLocation(location), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location){
        return new ResponseEntity<>(locationService.updateLocation(location), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable("id") Long locationId){
        return new ResponseEntity<>(locationService.viewLocation(locationId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable("id") Long locationId){
        return new ResponseEntity<>(locationService.deleteLocation(locationId), HttpStatus.OK);
    }
}
