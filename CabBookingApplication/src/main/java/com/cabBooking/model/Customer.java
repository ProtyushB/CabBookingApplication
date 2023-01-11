package com.cabBooking.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long customerId;

    String name;

    String phone;

    String email;

    String password;

    Byte age;

    String gender;

    @OneToOne
    Address address;

    String bankAccountNumber;

    public Customer() {
    }

    public Customer(Long customerId, String name, String phone, String email, String password, Byte age, String gender, Address address, String bankAccountNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
