package com.cg.invoiceservice;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.25;
        int time = 2;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }


    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5),
                new Ride(0.25,2)};
        InvoiceSummary summary= invoiceGenerator.calculateFare( rides );
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }


    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        try {
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            String userId = "akhil";
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)
            };
            invoiceGenerator.addRide(userId, rides);
            InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
            InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
            System.out.println(summary);
            System.out.println(expectedInvoiceSummary);
            Assert.assertEquals(expectedInvoiceSummary, summary);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMultipleRidesForuserid_ShouldReturnTotalFare() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = "akki";
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)
            };
            rideRepository.addRides(userId, rides);
            Ride[] summary = rideRepository.getRides(userId);
            System.out.println( Arrays.toString( summary ) );
            System.out.println( Arrays.toString( rides ) );
            Assert.assertEquals(rides, summary);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullRideswithEmptyuserId_ShouldthrowException() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = " ";
            Ride[] rides = null;
            rideRepository.addRides(userId, rides);
            Ride[] summary = rideRepository.getRides(userId);
            System.out.println( Arrays.toString( summary ) );
            System.out.println( Arrays.toString( rides ) );
            Assert.assertEquals(rides, summary);
         } catch (RideRepositoryException e) {
            e.printStackTrace();

        }
    }

    @Test
    public void givenMultipleRidesEmptyuserid_Shouldthrowexception() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = " ";
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)
            };
            rideRepository.addRides(userId, rides);
            Ride[] summary = rideRepository.getRides(userId);
            System.out.println( Arrays.toString( summary ) );
            System.out.println( Arrays.toString( rides ) );
            Assert.assertEquals(rides[0], summary[0]);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenEmptyRideswithuserid_Shouldthrowexception() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = "abc";
            Ride[] rides = null;
            rideRepository.addRides(userId, rides);
            Ride[] summary = rideRepository.getRides(userId);
            System.out.println( Arrays.toString( summary ) );
            System.out.println( Arrays.toString( rides ) );
            Assert.assertEquals(rides[0], summary[0]);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }
    }
}
