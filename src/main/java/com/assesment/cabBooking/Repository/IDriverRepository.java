package com.assesment.cabBooking.Repository;

import com.assesment.cabBooking.Entity.Driver;
import com.assesment.cabBooking.Entity.Location;
import com.assesment.cabBooking.Exceptions.DriverAlreadyBooked;
import com.assesment.cabBooking.Exceptions.DriverDoesNotExist;
import com.assesment.cabBooking.Exceptions.DriverExistException;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IDriverRepository {

    public boolean onBoardDriver(Driver driver) throws DriverExistException;
    public List<Driver> getAvailableDrivers();
    public boolean checkIsEligible(Driver driver , Location pickup, int maxdist );
    public boolean bookDriver(String driverid) throws DriverDoesNotExist, DriverAlreadyBooked;

}
