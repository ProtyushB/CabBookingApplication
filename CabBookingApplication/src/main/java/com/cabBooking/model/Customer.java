package com.cabBooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

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
    String email;

    //@Transient
    String password;

    Byte age;

    String gender;

    @OneToOne (cascade = CascadeType.ALL)
    Address address;

    String bankAccountNumber;

    //String otp;


}
