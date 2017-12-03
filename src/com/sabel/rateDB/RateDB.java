package com.sabel.rateDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RateDB {
    private List<Rate> liste;

    public RateDB(){
        this.liste = new ArrayList<>();
    }

    public int size(){
        return liste.size();
    }

    public boolean add(Rate rate){
        return liste.add(rate);
    }


    public boolean add(long timestamp, double rateEUR, double rateUSD){
        return liste.add(new Rate(timestamp,rateEUR,rateUSD))   ;
    }

    public Rate getLastRate(){
        return liste.get(liste.size()-1);
    }
    public Rate get(int index){
        return liste.get(index);
    }

    public List get(long beginTimestamp, long endTimestamp) {
        List<Rate> returnList = new ArrayList<>();
        for (Rate rate : liste) {

            if (rate.getTimestamp() >= beginTimestamp && rate.getTimestamp() <= endTimestamp) {
                returnList.add(rate);
            }
        }
        return returnList;
    }

    public Rate remove(long timestamp){
        Iterator<Rate> iterator = liste.iterator();
        while (iterator.hasNext()){
            Rate nextRate = iterator.next();
            if(nextRate.getTimestamp() == timestamp){
                iterator.remove();
                return nextRate;

            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Zeitstempel " + "RateInEuro\n");

        for (Rate rate: liste) {
            stringBuilder.append(rate.toString() + String.format("%n"));
        }
        return stringBuilder.toString();
    }
}
