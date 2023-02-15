package com.cabBooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long customerId;

    String name;

    @NotNull
    String phone;

    @Email
    @Column(unique = true)
    String email;

    //@Transient
    String password;

    Byte age;

    String gender;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Address address;

    String bankAccountNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Booking> allBookings = new ArrayList<>();



    //String otp;


}
