package com.budova.hostwin.dao;

import com.budova.hostwin.entity.AllSpentEntity;

import java.sql.*;

public class AllSpentDao {
    public static void put(AllSpentEntity entity) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/dbtest?useUnicode=true&amp&characterEncoding=UTF8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String username = "redlg";
            String password = "1234";
            Class.forName(driver);
            int gas = entity.getGasMeterId();
            double value = entity.getValue();
            long period = entity.getTime();
            Timestamp timestamp = new Timestamp(period);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected.");
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO gasmeter1 (a,b,c) VALUES ('" + gas + "','" + value + "','" + timestamp + "') ");
            preparedStatement.execute();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}