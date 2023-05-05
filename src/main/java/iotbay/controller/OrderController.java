package iotbay.controller;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.OrderDBManager;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderController {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private OrderDBManager db;
    public OrderController() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new OrderDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
