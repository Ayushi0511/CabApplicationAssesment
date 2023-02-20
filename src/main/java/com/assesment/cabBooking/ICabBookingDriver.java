package com.assesment.cabBooking;

import com.assesment.cabBooking.Entity.Driver;
import com.assesment.cabBooking.Entity.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICabBookingDriver {

    boolean add_user(String username, String usergender, int userage);

    public boolean add_driver(String drivername, int driverage, String drivergender, String vehicledetails, Location location);

    public List<Driver> find_ride(String userName, Location pickup,Location dest);

    public boolean choose_ride(String userName, String DriverID);

}
