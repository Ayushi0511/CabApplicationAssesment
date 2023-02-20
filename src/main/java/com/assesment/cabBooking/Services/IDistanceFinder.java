package com.assesment.cabBooking.Services;

import com.assesment.cabBooking.Entity.Location;
import org.springframework.stereotype.Service;

@Service
public interface IDistanceFinder {
    public int findDistance(Location loc1 ,Location loc2);
}
