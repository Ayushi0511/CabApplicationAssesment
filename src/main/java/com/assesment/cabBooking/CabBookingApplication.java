package com.assesment.cabBooking;

import com.assesment.cabBooking.Entity.Driver;
import com.assesment.cabBooking.Entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CabBookingApplication {



	public static void main(String[] args) {

		SpringApplication.run(CabBookingApplication.class, args);

/*
		ob.add_user("TESTUSER1","Male",23);
		ob.add_user("TESTUSER2","Female",23);
		ob.add_user("TESTUSER3","Female",23);

		Location lc1=new Location(10,1);
		Location lc2=new Location(11,1);
		Location lc3=new Location(5,3);

		ob.add_driver("Driver1",23,"Male","sx1",lc1);
		ob.add_driver("Driver2",23,"Male","sx1",lc2);
		ob.add_driver("Driver3",24,"feMale","sx1",lc3);

	//	ob.find_ride(“Abhishek” ,(0,0),(20,1))
		 lc1=new Location(0,0);
		 lc2=new Location(20,1);
		 List<Driver> rides=ob.find_ride("TESTUSER1",lc1,lc2);
		 System.out.println(rides);
*/



	}

}
