package com.cabBooking.Model;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long addressId;

    String apartmentNumber;

    String buildingName;

    String streeName;

    String coutry;

    String state;

    String city;

    String pincode;

    public Address() {
    }

    public Address(Long addressId, String apartmentNumber, String buildingName, String streeName, String coutry, String state, String city, String pincode) {
        this.addressId = addressId;
        this.apartmentNumber = apartmentNumber;
        this.buildingName = buildingName;
        this.streeName = streeName;
        this.coutry = coutry;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreeName() {
        return streeName;
    }

    public void setStreeName(String streeName) {
        this.streeName = streeName;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
