# CabApplicationAssesment

Implement a cab booking application. Below are the expected features from the system.

# Features:

The application allows users to book rides on a route.
Users can register themself.
Driving partner can onboard on the system with the vehicle details
Users can search and select one from multiple available rides on a route with the same source and destination based on the nearest to the user



#INFO
 
 - Starting driver of the application - > ICabBookingDriver which provides the functionality of adding user , adding driver , fetching rides etc
 - Some TestCases also added .
 - MAX_DIST IS configured in the config file application.properties where the defination of nearest can be changed .
 
 
 
#Improvements that can be done 
 - Can add another class for class details to make it a seprate entity
 - For Multithreading , I can add a Read Write lock in the Services who are fetching and booking the ride , so that multiple threads can fetch the list of rides available 
   but writelock shouldn't be there while reading . 
 


