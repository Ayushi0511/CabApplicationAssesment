package com.assesment.cabBooking;

import com.assesment.cabBooking.Entity.Driver;
import com.assesment.cabBooking.Entity.Location;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class CabBookingApplicationTests {
@Autowired
 ICabBookingDriver ob;

@Value("${cabApplication.config.MAX_DIST}")
int MAX_DIST;

	@Test
	void contextLoads() {
	}

	 void CreateUserandDrivers(){
		ob.add_user("TESTUSER1","Male",23);
		ob.add_user("TESTUSER2","Female",23);
		ob.add_user("TESTUSER3","Male",23);

		Location loc1=new Location(10,1);
		Location loc2=new Location(11,10);
		Location loc3=new Location(5,3);

		ob.add_driver("DRIVER1",23,"Male","Swift",loc1);
		ob.add_driver("DRIVER2",24,"Female","Swift",loc2);
		ob.add_driver("DRIVER3",25,"Male","Maruti",loc3);
	}

	@Test
	void testRideWithFatherthanGivenFarthestDist(){
		CreateUserandDrivers();


		Location pickup=new Location(0,0);
		Location dest=new Location(20+MAX_DIST,1+MAX_DIST);

		List<Driver> test1= ob.find_ride("TESTUSER1",pickup,dest);

		assertEquals(test1.size(),0);


	}
	@Test
	void testRidewithinthegivenDist(){

		//CreateUserandDrivers();

		Location newdriverlocation=new Location(MAX_DIST-1,0);
		ob.add_driver("DRIVER4",23,"Male","Swift",newdriverlocation);

		Location pickup=new Location(0,0);
		Location dest=new Location(10,11);

		List<Driver> test2=ob.find_ride("TESTUSER2",pickup,dest);

		assertTrue(test2.size()>0);
		assertTrue(test2.stream().anyMatch((d)->d.getDriverid()=="DRIVER4"));

	}

	@Test
	void testNotbookrideifNotAvailable(){

		//CreateUserandDrivers();

		Location newdriverlocation=new Location(MAX_DIST-1,0);
		ob.add_driver("DRIVER4",23,"Male","Swift",newdriverlocation);

		Location pickup=new Location(0,0);
		Location dest=new Location(10,11);

		List<Driver> test2=ob.find_ride("TESTUSER2",pickup,dest);



		assertTrue(test2.size()>0);
		assertTrue(test2.stream().anyMatch((d)->d.getDriverid()=="DRIVER4"));

		ob.choose_ride("TESTUSER1",test2.get(0).getDriverid());

		List<Driver> test3=ob.find_ride("TESTUSER2",pickup,dest);
		assertFalse(test3.stream().anyMatch((d)->d.getDriverid()=="DRIVER4"));

	}




}
