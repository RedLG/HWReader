package com.budova.hostwin.dto;

import com.budova.hostwin.entity.AllSpentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FromDB {
    public static AllSpentEntity getLast(int gasMeterId) {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/dbtest?useUnicode=true&amp&characterEncoding=UTF8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String username = "redlg";
            String password = "1234";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected.");
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT b, c FROM `dbtest`.`gasmeter1` WHERE a = "+ gasMeterId +" ORDER BY c DESC LIMIT 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AllSpentEntity(
                        gasMeterId,
                        resultSet.getDouble("b"),
                        resultSet.getTimestamp("c").getTime()
                );
            }
            conn.close();
            return new AllSpentEntity(
                    gasMeterId,
                    0,
                    0
            );
        }
        catch (Exception e) {
            e.printStackTrace();
            return new AllSpentEntity(
                    gasMeterId,
                    0,
                    0
            );
        }
    }
}
