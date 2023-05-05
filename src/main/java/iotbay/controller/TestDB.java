/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.controller;
import iotbay.model.Customer;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.DBManager;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
/**
 *
 * @author tomgolding
 */
public class TestDB {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBManager db = new DBManager(conn);

            ArrayList<Customer> l = db.fetchCustomers();

            l.stream().forEach(a -> {
                System.out.println(a.getCustomerEmail());
            });
            connector.closeConnection();
        } catch(ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
