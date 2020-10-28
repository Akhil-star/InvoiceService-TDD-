package com.cg.invoiceservice;

public class InvoiceGenerator {

    RideRepository rideRepository = new RideRepository();

    public InvoiceSummary calculateFare(Ride[] rides){
        double totalFare = 0;
        for(Ride ride : rides){
            totalFare = totalFare + ride.calculateFare( ride.distance, ride.time);
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
