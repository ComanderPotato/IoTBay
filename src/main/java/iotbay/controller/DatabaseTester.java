package iotbay.controller;

import iotbay.model.dao.CustomerDBManager;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.OrderDBManager;



import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseTester {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            // Instantiate what DAO object you want to test
            CustomerDBManager db  = new CustomerDBManager(conn);


            // Call function here you want to test


        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
