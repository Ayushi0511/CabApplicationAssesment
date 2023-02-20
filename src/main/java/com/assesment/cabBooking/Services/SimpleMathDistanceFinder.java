package com.assesment.cabBooking.Services;

import com.assesment.cabBooking.Entity.Location;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SimpleMathDistanceFinder implements IDistanceFinder {

    @Override
    public int findDistance(Location loc1, Location loc2) {
       int x1=loc1.getxCoordinates();
       int y1=loc1.getyCoordinates();

       int x2=loc2.getxCoordinates();
       int y2=loc2.getyCoordinates();

       int dist= (int) Math.ceil(Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2)));

       return dist;
    }
}
