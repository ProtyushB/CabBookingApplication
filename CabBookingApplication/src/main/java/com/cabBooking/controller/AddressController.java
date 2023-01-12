package com.cabBooking.controller;

import com.cabBooking.model.Address;
import com.cabBooking.serviceLayer.address.AddressService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.updateAddress(address), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable("id") Long addressId){
        return new ResponseEntity<>(addressService.viewAddress(addressId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long AddressId){
        return new ResponseEntity<>(addressService.deleteAddress(AddressId), HttpStatus.OK);
    }
}
