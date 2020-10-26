package com.cg.invoiceservice;

import org.junit.Assert;
import org.junit.Test;

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
    public void givenMultipleRidesShouldReturnTotalfare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0,5),
                        new Ride(0.25,2)};
        double fare = invoiceGenerator.calculateFare( rides );
        Assert.assertEquals(30,fare,0.0);
    }
}
