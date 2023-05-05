/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.model.dao;
import iotbay.model.Customer;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author tomgolding
 */
public class DBManager {
    private Statement stmt;
    
    public DBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
    }
    
    public void addCustomer(
            String customerEmail, 
            String customerPassword, 
            String customerFirstName, 
            String customerLastName,
            String customerDOB,
            String customerPhone
            ) throws SQLException{
        System.out.println("HELOO");
        stmt.executeUpdate(String.format("INSERT INTO CUSTOMER "
                        + "(customerEmail, customerPassword, customerFirstName, " +
                        "customerLastName, customerDOB, customerPhone)"
                        + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
                        customerEmail, customerPassword, customerFirstName,
                        customerLastName, customerDOB, customerPhone));
        // prepare statement
    }
//    public void
    public void deleteCustomer(String email) throws SQLException {
        stmt.executeUpdate("DELETE FROM CUSTOMER WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<Customer> fetchCustomers() throws SQLException {
        String fetch = "SELECT * FROM CUSTOMER";
        ResultSet rs = stmt.executeQuery(fetch);
        ArrayList<Customer> temp = new ArrayList();
        while(rs.next()) {
            int id = rs.getInt("customerID");
            String email = rs.getString("customerEmail");
            String password = rs.getString("customerPassword");
            String fName = rs.getString("customerFirstName");
            String lName = rs.getString("customerLastName");
            String dob = rs.getString("customerDOB");
            String phone = rs.getString("customerPhone");
            temp.add(new Customer(id, email, password, fName, lName, dob, phone));
        }
        return temp;
    }
}
