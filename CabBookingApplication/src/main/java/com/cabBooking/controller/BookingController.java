package com.cabBooking.controller;

import com.cabBooking.model.Booking;
import com.cabBooking.serviceLayer.booking.BookingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.awt.print.Book;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.addBooking(booking), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.updateBooking(booking), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> viewBooking(@PathVariable("id") Long bookingId){
        return new ResponseEntity<>(bookingService.viewBooking(bookingId), HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") Long bookingId){
        return new ResponseEntity<>(bookingService.deleteBooking(bookingId), HttpStatus.OK);
    }

    //Get ALl Booking From Customer Controller
}
