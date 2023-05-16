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
public abstract class DB {
    protected String driver = "org.sqlite.JDBC";
    protected String url = "jdbc:sqlite:C:\\Users\\Tom\\IdeaProjects\\IoTBay\\iotbay.db";
    protected Connection conn;
}
