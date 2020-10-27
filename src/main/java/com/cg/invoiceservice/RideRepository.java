package com.cg.invoiceservice;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides = null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public ArrayList<Ride> addRides(String userId, Ride[] rides) throws RideRepositoryException {
        if (rides != null && userId != " ")
            return this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
        else if(rides == null && userId !=" ")
            throw new RideRepositoryException("Rides are Empty", RideRepositoryException.ExceptionType.NO_RIDE_FOUND);
        else if(userId == " " && rides != null)
            throw new RideRepositoryException("User id is empty", RideRepositoryException.ExceptionType.NULL_VALUE);
        else
            throw new RideRepositoryException("Rides and userid are empty", RideRepositoryException.ExceptionType.NO_RIDE_FOUND);

    }

    public Ride[] getRides(String userId)  {
        return this.userRides.get( userId ).toArray( new Ride[userRides.size()] );
    }
}
