package com.cg.invoiceservice;

public class InvoiceGenerator {
    private static final int costPerTime = 1;
    private static final int minimumCostPerKm = 10;
    private static final double minimumFare = 5;
    public double calculateFare(double distance, int time) {
        double fare =  distance * minimumCostPerKm + time * costPerTime;
        if(fare < minimumFare)
            return minimumFare;
        else
            return fare;
    }
}
