package com.assesment.cabBooking.Repository;

import com.assesment.cabBooking.Entity.Driver;
import com.assesment.cabBooking.Entity.Location;
import com.assesment.cabBooking.Exceptions.DriverAlreadyBooked;
import com.assesment.cabBooking.Exceptions.DriverDoesNotExist;
import com.assesment.cabBooking.Exceptions.DriverExistException;
import com.assesment.cabBooking.Services.IDistanceFinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
@Primary
public class DriverRepository implements  IDriverRepository {
    HashMap<String , Driver> driverOnboarded;
    Logger logger= (Logger) LoggerFactory.getLogger(DriverRepository.class);

    @Autowired
    IDistanceFinder distanceFinder;
    public DriverRepository() {
        this.driverOnboarded=new HashMap<>();
    }

    @Override
    public boolean onBoardDriver(Driver driver) throws DriverExistException {
       String driverId=driver.getDriverid();

       if(driverOnboarded.containsKey(driverId)) {
          logger.error("Driver with id "+driverId+" Already Exists");
           throw new DriverExistException();
       }
       driverOnboarded.put(driverId,driver);
       return true;
    }

    @Override
    public List<Driver> getAvailableDrivers() {
        List<Driver> availableDrivers=new ArrayList<>();
        for(String Driver: driverOnboarded.keySet()){
            if(driverOnboarded.get(Driver).isAvailable())
                availableDrivers.add(driverOnboarded.get(Driver));
        }

         return availableDrivers;
    }

    @Override
    public boolean checkIsEligible(Driver driver, Location pickup, int maxdist) {
      Location driverLocation=driver.getCurrLocation();
      int distance=  distanceFinder.findDistance(driverLocation,pickup);

      if(distance>5)
          return false;

      return true;
    }

    @Override
    public boolean bookDriver(String driverid) throws DriverDoesNotExist, DriverAlreadyBooked {

       Driver driver=driverOnboarded.get(driverid);

       if(driver==null)
       {
           logger.error("ERROR :Driver id "+driverid+ " is incorrect ");
           throw new DriverDoesNotExist();

       }
       if(!driver.isAvailable())
       {
           logger.error("ERROR :Driver is already booked");
          throw new DriverAlreadyBooked();
       }
       driver.setAvailable(false);
       return true;
    }
}
