package iotbay.model.dao;
import iotbay.model.Customer;
import iotbay.model.UserAccount;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public CustomerDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public void addCustomer
            (
            String customerEmail,
            String customerPassword,
            String customerFirstName,
            String customerLastName,
            String customerDOB,
            String customerPhone
            ) throws SQLException
    {
        prepStmt = conn.prepareStatement(
                            "INSERT INTO CUSTOMER " +
                                "(customerEmail, customerPassword, customerFirstName, " +
                                "customerLastName, customerDOB, customerPhone) VALUES (?, ? ,? ,? ,? ,?);");
        prepStmt.setString(1, customerEmail);
        prepStmt.setString(2, customerPassword);
        prepStmt.setString(3, customerFirstName);
        prepStmt.setString(4, customerLastName);
        prepStmt.setString(5, customerDOB);
        prepStmt.setString(6, customerPhone);
        prepStmt.executeUpdate();
        prepStmt.close();

    }
    public Customer findCustomer(String email, String password) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE EMAIL = ? AND PASSWORD = ?;");
        prepStmt.setString(1, email);
        prepStmt.setString(2, password);

        ResultSet rs = prepStmt.executeQuery();
        prepStmt.close();
        while(rs.next()) {
            String customerEmail = rs.getString("customerEmail");
            String customerPassword = rs.getString("customerPassword");
            if (email.equals(customerEmail) && password.equals(customerPassword)) {
                int id = rs.getInt("customerID");
                String fName = rs.getString("customerFirstName");
                String lName = rs.getString("customerLastName");
                String dob = rs.getString("customerDOB");
                String phone = rs.getString("customerPhone");
                return new Customer(id, customerEmail, customerPassword, fName, lName, dob, phone);
            }
        }
        return null;
    }
    public ArrayList<Customer> getCustomers() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
        ArrayList<Customer> temp = new ArrayList<>();

        while(rs.next()) {
            int ID = rs.getInt("customerID");
            String email = rs.getString("customerEmail");
            String password = rs.getString("customerPassword");
            String fName = rs.getString("customerFirstName");
            String lName = rs.getString("customerLastName");
            String dob = rs.getString("customerDOB");
            String phone = rs.getString("customerPhone");
            temp.add(new Customer(ID, email, password, fName, lName, dob, phone));
        }
        return temp;
    }

    public UserAccount findAssociatedAccount(int customerID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USERACCOUNT WHERE CUSTOMERID = ?");
        prepStmt.setInt(1, customerID);

        rs = prepStmt.executeQuery();

        while(rs.next()) {
            if(rs.getInt("customerID") == customerID) {
                int userAccountID = rs.getInt("userAccountID");
                int paymentID = rs.getInt("paymentID");
                int orderHistoryID = rs.getInt("orderHistoryID");
                int orderTrackingID = rs.getInt("orderTrackingID");
                int addressID = rs.getInt("addressID");
                int cartID = rs.getInt("cartID");
                return new UserAccount(userAccountID, customerID, paymentID, orderHistoryID, orderTrackingID, addressID, cartID);
            }
        }
        return null;
    }
}
