package com.sabel.rateDB;

import java.sql.SQLException;
import java.util.Date;

public class Testklasse {
    public static void main(String[] args) {
        Rate rate1 = new Rate(new Date().getTime()/1000, 8845.54, 89.48);
        //System.out.println(rate1);
        RatesServices ratesService = null;
        try {
            ratesService= new RatesServices();
            // ratesService.save(rate1);
            RateDB rateDB = ratesService.readAllRates();
            //System.out.println(rateDB);
            System.out.println(ratesService.readLastRate());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ratesService.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
