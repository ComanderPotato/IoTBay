/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.model.dao;

import java.sql.*;

/**
 *
 * @author tomgolding
 */
public class DBConnector extends DB {
    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(url);
    }
    public Connection openConnection() {
        return this.conn;
    }
    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
