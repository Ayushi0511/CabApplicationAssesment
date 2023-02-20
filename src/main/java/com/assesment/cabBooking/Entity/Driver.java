package com.assesment.cabBooking.Entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class Driver {
    private String driverid;// assuming driver name give during registration is some kind og userid
    private String gender;
    private  int age;
    private  Location currLocation;
    private String cardetails;
    private boolean isAvailable;

    public Driver(String driverid, String gender, int age, Location currLocation, String cardetails) {
        this.driverid = driverid;
        this.gender = gender;
        this.age = age;
        this.currLocation = currLocation;
        this.cardetails = cardetails;
        this.isAvailable=true;
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Location getCurrLocation() {
        return currLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public String getCardetails() {
        return cardetails;
    }

    public void setCardetails(String cardetails) {
        this.cardetails = cardetails;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
