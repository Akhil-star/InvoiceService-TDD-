package com.cg.invoiceservice;

public class Ride {

    private static final int costPerTimeForNormal = 1;
    private static final int minimumCostPerKmForNormal = 10;
    private static final double minimumFareForNormal = 5;
    private static final int costPerTimeForPremium = 2;
    private static final int minimumCostPerKmForPremium = 15;
    private static final double minimumFareForPremium = 20;
    public double distance ;
    public int time;

    public enum cabType{
        NORMAL,PREMIUM,OTHER
    }

    public cabType cab;
    public Ride(double distance, int time, cabType cab){
        this.distance = distance;
        this.time = time;
        this.cab = cab;
    }

    public double calculateFare(double distance, int time) {
        if(Ride.cabType.NORMAL.equals( cab )) {
            double totalFare = distance * minimumCostPerKmForNormal + time * costPerTimeForNormal;
            if (totalFare < minimumFareForNormal)
                return minimumFareForNormal;
            else
                return totalFare;
        }if(Ride.cabType.PREMIUM.equals( cab )){
            double totalFare = distance * minimumCostPerKmForPremium + time * costPerTimeForPremium;
            if (totalFare < minimumFareForPremium)
                return minimumFareForPremium;
            else
                return totalFare;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "distance=" + distance +
                ", time=" + time +
                ", cabType="+cab+
                '}';
    }
}
