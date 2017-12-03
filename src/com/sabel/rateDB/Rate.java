package com.sabel.rateDB;

public class Rate {

    private long timestamp;
    private double rateEUR, rateUSD;



    public Rate(){

    }

    public Rate(long timestamp, double rateEUR, double rateUSD) {
        this.timestamp = timestamp;
        this.rateEUR = rateEUR;
        this.rateUSD = rateUSD;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getRateEUR() {
        return rateEUR;
    }

    public void setRateEUR(double rateEUR) {
        this.rateEUR = rateEUR;
    }

    public double getRateUSD() {
        return rateUSD;
    }

    public void setRateUSD(double rateUSD) {
        this.rateUSD = rateUSD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        if (timestamp != rate.timestamp) return false;
        if (Double.compare(rate.rateEUR, rateEUR) != 0) return false;
        return Double.compare(rate.rateUSD, rateUSD) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (timestamp ^ (timestamp >>> 32));
        temp = Double.doubleToLongBits(rateEUR);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rateUSD);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString(){
        return timestamp +"\t" + rateEUR;
    }

}
