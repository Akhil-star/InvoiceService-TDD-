package com.cg.invoiceservice;

public class InvoiceSummary {
    private int numOfRides;
    private double totalFare;
    private double average;
    public InvoiceSummary(int numOfRides, double totalFare){
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.average = this.totalFare/this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides &&
                Double.compare( that.totalFare, totalFare ) == 0 &&
                Double.compare( that.average, average ) == 0;
    }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "numOfRides=" + numOfRides +
                ", totalFare=" + totalFare +
                ", average=" + average +
                '}';
    }
}
