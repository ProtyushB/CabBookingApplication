package com.cabBooking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long vehicleOwnerId;

    String name;

    String phone;

    @Email
    @Column(unique = true)
    String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    Byte age;

    String gender;

    String adhaarNumber;

    String bankAccountNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Vehicle> allVehicles = new ArrayList<>();
}
