package com.cg.invoiceservice;

public class InvoiceGenerator {
    private static final int costPerTime = 1;
    private static final int minimumCostPerKm = 10;
    private static final double minimumFare = 5;
    RideRepository rideRepository = new RideRepository();

    public double calculateFare(double distance, int time) {
        double totalFare =  distance * minimumCostPerKm + time * costPerTime;
        if(totalFare < minimumFare)
            return minimumFare;
        else
            return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride : rides){
            totalFare = totalFare + this.calculateFare( ride.distance, ride.time);
        }
        return new InvoiceSummary( rides.length, totalFare);
    }

    public void addRide(String userId, Ride[] rides) throws RideRepositoryException {
        rideRepository.addRides( userId, rides );
    }

    public InvoiceSummary getInvoiceSummary(String userId)  {
        Ride[] rides = rideRepository.getRides( userId );
        return this.calculateFare(rides);
    }
}
