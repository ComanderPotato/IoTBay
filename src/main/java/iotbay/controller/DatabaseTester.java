package iotbay.controller;

import iotbay.model.Customer;
import iotbay.model.UserAccount;
import iotbay.model.dao.CustomerDBManager;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.OrderDBManager;
import iotbay.model.dao.UserAccountDBManager;
import iotbay.model.CartItem;
import java.util.ArrayList;

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
            UserAccountDBManager udb = new UserAccountDBManager(conn);
            OrderDBManager odb = new OrderDBManager(conn);
            Customer customer = db.findCustomer("tomgolding2012@outlook.com", "password1");
            UserAccount userAccount = db.findAssociatedAccount(customer.getCustomerID());

            ArrayList<CartItem> itemList = new ArrayList<>();

            // Call function here you want to test


        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
