package com.cabBooking.serviceLayer.customer;

import com.cabBooking.dao.AddressDao;
import com.cabBooking.dao.BookingDao;
import com.cabBooking.dao.CustomerDao;
import com.cabBooking.dao.VehicleDao;
import com.cabBooking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private BookingDao bookingDao;



    @Override
    public Customer addCustomer(Customer customer) {

        Optional<Customer> optionalCustomer = customerDao.findByEmail(customer.getEmail());
        if (optionalCustomer.isPresent()){
            //Customer Already Exists
        }
        return customerDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer cust = null;

        Optional<Customer> optionalCustomer = customerDao.findById(customer.getCustomerId());

        if (optionalCustomer.isPresent()){
            cust = customerDao.save(customer);
        }
        else{
            //Customer Not Exists
        }

        return cust;
    }

    @Override
    public Customer viewCustomer(Long customerId) {
        Customer cust = null;

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()) cust = optionalCustomer.get();
        else{
            //Customer Not Exists
        }

        return cust;
    }

    @Override
    public String deleteCustomer(Long customerId) {

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()) customerDao.deleteById(customerId);
        else {
            //Customer Not Exists
        }
        return "Customer Deleted Successfully";
    }






    @Override
    public String newBooking(Booking booking, Long customerId, Long vehicleId) {
        Customer customer = null;
        Vehicle vehicle = null;
        Driver driver = null;

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()){
            customer = optionalCustomer.get();

            Optional<Vehicle> optionalVehicle = vehicleDao.findById(vehicleId);

            if (optionalVehicle.isPresent()){
                vehicle = optionalVehicle.get();

                driver = vehicle.getDriver();

                booking = bookingDao.save(booking);
                vehicle.getAllBookings().add(booking);
                driver.getAllBookings().add(booking);
                customer.getAllBookings().add(booking);
            }
            else {
                //Vehicle Not Found
            }
        }
        else{
            //Customer Not Found
        }
        return "Booking Confirmed";
    }







    @Override
    public List<Booking> getAllBookings(Long customerId) {
        Customer customer = null;
        List<Booking> allBookings = customer.getAllBookings();

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()){
            customer = optionalCustomer.get();

            if(allBookings.size()==0) {/* No Bookings Available*/}
        }
        else {
            //Customer Not Found
        }

        return allBookings;
    }

    @Override
    public List<Booking> getBookingHistory(Long customerId) {
        Customer customer = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> bookingHistory = new ArrayList<>();

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
            allBookings = customer.getAllBookings();

            for (Booking b:allBookings) if(b.getBookingStatus().equals("Completed")) bookingHistory.add(b);

            if (bookingHistory.size()==0) {/* Booking History Not Available */}
        }
        else {
            //Customer Not Found
        }

        return bookingHistory;
    }

    @Override
    public List<Booking> getActiveBookings(Long customerId) {
        Customer customer = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> activeBookings =new ArrayList<>();

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
            allBookings = customer.getAllBookings();

            for(Booking b:allBookings) if (b.getBookingStatus().equals("Active")) activeBookings.add(b);

            if (activeBookings.size()==0) {/* No Active Bookings Found */}
        }
        else{
            //Customer Not Found
        }

        return activeBookings;
    }

    @Override
    public List<Booking> getUpComingBookings(Long customerId) {
        Customer customer = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> upComingBookings = new ArrayList<>();

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
            allBookings = customer.getAllBookings();

            for(Booking b:allBookings) if (b.getBookingStatus().equals("Upcoming")) upComingBookings.add(b);

            if (upComingBookings.size()==0) {/* No Upcoming Bookings Found */}
        }
        else{
            //Customer Not Found
        }

        return upComingBookings;
    }

    @Override
    public List<Booking> getCancelledBookings(Long customerId) {
        Customer customer = null;
        List<Booking> allBookings = new ArrayList<>();
        List<Booking> cancelledBookings = new ArrayList<>();

        Optional<Customer> optionalCustomer = customerDao.findById(customerId);

        if (optionalCustomer.isPresent()){
            customer = optionalCustomer.get();
            allBookings = customer.getAllBookings();

            for (Booking b:allBookings) if (b.getBookingStatus().equals("Cancelled")) cancelledBookings.add(b);

            if (cancelledBookings.size()==0) {/* No Cancelled Bookings Available */}
        }
        else{
            //Customer Not Found
        }

        return cancelledBookings;
    }

}
