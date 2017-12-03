package com.sabel.rateDB;

import java.sql.*;

public class RatesServices {
    private Connection connection;
    private PreparedStatement pStatInsert, pStatSelect, pStatSelectLast;
    private static final String URL = "jdbc:sqlite:d:\\rateDB.sqlite";

    public RatesServices() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.pStatInsert = connection.prepareStatement("Insert into rate(TIMESTAMP , rateEUR, rateUSD) VALUES (?,?,?)");
        this.pStatSelect = connection.prepareStatement("Select * from rate");
        this.pStatSelectLast = connection.prepareStatement("Select TIMESTAMP , rateEUR, rateUSD from rate order by TIMESTAMP desc 1");
    }

    public void save(Rate rate) throws SQLException {
        pStatInsert.setLong(1, rate.getTimestamp());
        pStatInsert.setDouble(2, rate.getRateEUR());
        pStatInsert.setDouble(3, rate.getRateUSD());
    }

    public void close() throws SQLException {
        if (connection != null){

            connection.close();
    }
        connection = null;

}
    public RateDB readAllRates() throws SQLException {
        RateDB rateDB = new RateDB();
        ResultSet resultSet = pStatSelect.executeQuery();

        while (resultSet.next()) {
            Rate rate = new Rate();
            rate = new Rate();
            rate.setTimestamp(resultSet.getLong(1));
            rate.setRateEUR(resultSet.getDouble(2));
            rate.setRateUSD(resultSet.getDouble(3));
            rateDB.add(rate);
        }
        return rateDB;

    }
    public Rate readLastRate() throws SQLException {
        ResultSet resultSet = pStatSelect.executeQuery();
        Rate rate = null;
        if(resultSet.next()){
            rate = new Rate();
            rate.setTimestamp(resultSet.getLong(1));
            rate.setRateEUR(resultSet.getDouble(2));
            rate.setRateUSD(resultSet.getDouble(3));
        }
        return rate;
    }


}

