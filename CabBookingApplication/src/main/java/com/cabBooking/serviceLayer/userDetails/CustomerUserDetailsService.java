package com.cabBooking.serviceLayer.userDetails;

import com.cabBooking.dao.CustomerDao;
import com.cabBooking.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDao.findByEmail(username)
                .orElseThrow(()->new BadCredentialsException("Customer Not Found with Username: "+username));

        List<GrantedAuthority> authorities = new ArrayList<>();

        return new CustomerUserDetails(customer);
    }
}
