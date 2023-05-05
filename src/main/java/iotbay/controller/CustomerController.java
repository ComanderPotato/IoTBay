package iotbay.controller;
import iotbay.model.Customer;
import iotbay.model.dao.CustomerDBManager;
import iotbay.model.dao.DBConnector;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
public class CustomerController {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private CustomerDBManager db;

    public CustomerController() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new CustomerDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void addCustomer() {
//        db.addCustomer();
//    }
}
