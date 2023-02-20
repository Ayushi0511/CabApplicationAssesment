package com.assesment.cabBooking;

import com.assesment.cabBooking.Entity.Driver;
import com.assesment.cabBooking.Entity.Location;
import com.assesment.cabBooking.Entity.User;
import com.assesment.cabBooking.Exceptions.DriverAlreadyBooked;
import com.assesment.cabBooking.Exceptions.DriverDoesNotExist;
import com.assesment.cabBooking.Exceptions.DriverExistException;
import com.assesment.cabBooking.Repository.DriverRepository;
import com.assesment.cabBooking.Repository.IDriverRepository;
import com.assesment.cabBooking.Repository.IUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CabBookingDriver implements  ICabBookingDriver{
    @Autowired
    IDriverRepository driverRepository;
    @Autowired
    IUserRepository userRepository;

    @Value("${cabApplication.config.MAX_DIST}")
    int MAX_DIST;

    Logger logger= (Logger) LoggerFactory.getLogger(DriverRepository.class);
    @Override
    public boolean add_user(String username,String usergender, int userage) {
        User user=new User(username,usergender,userage);
        userRepository.onBoardUser(user);
        return true;
    }

    @Override
    public boolean add_driver(String drivername, int driverage, String drivergender, String vehicledetails, Location location) {
        Driver driver= new Driver(drivername,drivergender,driverage,location,vehicledetails);
        try {
            driverRepository.onBoardDriver(driver);
        } catch (DriverExistException e) {
           logger.info("Could'nt board the Driver");
           return false;
        }
        return true;
    }

    @Override
    public List<Driver> find_ride(String userName, Location pickup,Location dest) {
       List<Driver> avDrivers= driverRepository.getAvailableDrivers();
       List<Driver> availableEligibleDrivers=new ArrayList<>();
       for(Driver d : avDrivers){
           if(driverRepository.checkIsEligible(d,pickup,MAX_DIST))
               availableEligibleDrivers.add(d);
       }
       if(availableEligibleDrivers.size()==0){
           logger.info(" No available driver within 5 dist range");
       }
       return availableEligibleDrivers;
    }

    @Override
    public boolean choose_ride(String userName, String driverID) {
        try {
            boolean result= driverRepository.bookDriver(driverID);
        } catch (DriverDoesNotExist | DriverAlreadyBooked e) {
            logger.info(" COULD'NT BOOK");
            return false;
        }
      return true;
    }
}
