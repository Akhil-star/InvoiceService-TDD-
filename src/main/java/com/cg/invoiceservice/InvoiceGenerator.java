package com.cg.invoiceservice;

public class InvoiceGenerator {
    private static final int costPerTime = 1;
    private static final int minimumCostPerKm = 10;
    private static final double minimumFare = 5;
    public double calculateFare(double distance, int time) {
        double totalFare =  distance * minimumCostPerKm + time * costPerTime;
        if(totalFare < minimumFare)
            return minimumFare;
        else
            return totalFare;
    }

    public double calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride : rides){
            totalFare = totalFare + this.calculateFare( ride.distance, ride.time);
        }
        return totalFare;
    }
}
