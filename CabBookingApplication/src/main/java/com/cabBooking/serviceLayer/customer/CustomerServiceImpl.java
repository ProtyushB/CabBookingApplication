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
        Customer cust = null;

        //Checking With Email
        if (customer.getEmail()!=null){
            cust = customerDao.findCustomerByEmail(customer.getEmail());

            if (cust==null){
                cust = customerDao.save(customer);
            }
            else {
                // Customer With Email Already Exists
            }
        }

        //Checking With Phone
        if (customer.getPhone()!=null){
            cust = customerDao.findCustomerByPhone(customer.getPhone());

            if (cust==null){
                cust = customerDao.save(customer);
            }
            else {
                //Customer With Phone Already Exists
            }
        }

        return cust;
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
        List<Booking> allBookings = bookingDao.getAllBookings(customerId);

        if(allBookings.size()==0) {/* No Bookings Available*/}

        return allBookings;
    }

    @Override
    public List<Booking> getBookingHistory(Long customerId) {
        List<Booking> allBookings = bookingDao.getAllBookings(customerId);
        List<Booking> bookingHistory = new ArrayList<>();

        for (Booking b:allBookings) if(b.getBookingStatus().equals("Completed")) bookingHistory.add(b);

        if (bookingHistory.size()==0) {/* Booking History Not Available */}

        return bookingHistory;
    }

    @Override
    public List<Booking> getActiveBookings(Long customerId) {
        List<Booking> allBookings = bookingDao.getAllBookings(customerId);
        List<Booking> activeBookings =new ArrayList<>();

        for(Booking b:allBookings) if (b.getBookingStatus().equals("Active")) activeBookings.add(b);

        if (activeBookings.size()==0) {/* No Active Bookings Found */}

        return activeBookings;
    }

    @Override
    public List<Booking> getUpComingBookings(Long customerId) {
        List<Booking> allBookings = bookingDao.getAllBookings(customerId);
        List<Booking> upComingBookings = new ArrayList<>();

        for(Booking b:allBookings) if (b.getBookingStatus().equals("Upcoming")) upComingBookings.add(b);

        if (upComingBookings.size()==0) {/* No Upcoming Bookings Found */}

        return upComingBookings;
    }

    @Override
    public List<Booking> getCancelledBookings(Long customerId) {
        List<Booking> allBookings = bookingDao.getAllBookings(customerId);
        List<Booking> cancelledBookings = new ArrayList<>();

        for (Booking b:allBookings) if (b.getBookingStatus().equals("Cancelled")) cancelledBookings.add(b);

        if (cancelledBookings.size()==0) {/* No Cancelled Bookings Available */}

        return cancelledBookings;
    }

}
