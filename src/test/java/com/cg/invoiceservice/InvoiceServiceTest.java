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
        Ride ride = new Ride( distance,time, Ride.cabType.NORMAL );
        double fare = ride.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.25;
        int time = 2;
        Ride ride = new Ride( distance,time, Ride.cabType.NORMAL );
        double fare = ride.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }


    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5, Ride.cabType.NORMAL),
                new Ride(0.25,2, Ride.cabType.NORMAL)};
        InvoiceSummary summary= invoiceGenerator.calculateFare( rides );
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }


    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        try {
            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            String userId = "akhil";
            Ride[] rides = {new Ride(2.0, 5, Ride.cabType.NORMAL),
                    new Ride(0.1, 1, Ride.cabType.NORMAL)
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
            Ride[] rides = {new Ride(2.0, 5, Ride.cabType.NORMAL),
                    new Ride(0.1, 1, Ride.cabType.NORMAL)
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
            Ride[] rides = {new Ride(2.0, 5, Ride.cabType.NORMAL),
                    new Ride(0.1, 1, Ride.cabType.NORMAL)
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

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFareForPremium() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        Ride ride = new Ride( distance,time, Ride.cabType.PREMIUM );
        double fare = ride.calculateFare(distance,time);
        Assert.assertEquals(40,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFareForPremium() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.25;
        int time = 2;
        Ride ride = new Ride( distance,time, Ride.cabType.PREMIUM );
        double fare = ride.calculateFare(distance,time);
        Assert.assertEquals(20,fare,0.0);
    }


    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummaryForPremium() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5, Ride.cabType.PREMIUM),
                new Ride(0.25,2, Ride.cabType.PREMIUM)};
        InvoiceSummary summary= invoiceGenerator.calculateFare( rides );
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,60);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummaryOnePremiumAndOneNormal() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5, Ride.cabType.PREMIUM),
                new Ride(0.25,2, Ride.cabType.NORMAL)};
        InvoiceSummary summary= invoiceGenerator.calculateFare( rides );
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,45);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }

    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummaryNoType() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5, Ride.cabType.OTHER),
                new Ride(0.25,2, Ride.cabType.NORMAL)};
        InvoiceSummary summary= invoiceGenerator.calculateFare( rides );
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,5);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }


}
