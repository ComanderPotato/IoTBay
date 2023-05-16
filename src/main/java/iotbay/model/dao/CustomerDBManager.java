package iotbay.model.dao;
import iotbay.model.Customer;
import iotbay.model.UserAccount;
import iotbay.model.dao.UserAccountDBManager;

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
            (int registrationID,
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
                                "(registrationID, customerEmail, customerPassword, customerFirstName, " +
                                "customerLastName, customerDOB, customerPhone) VALUES (?, ? ,? ,? ,? , ?, ?);");
        prepStmt.setInt(1, registrationID);
        prepStmt.setString(2, customerEmail);
        prepStmt.setString(3, customerPassword);
        prepStmt.setString(4, customerFirstName);
        prepStmt.setString(5, customerLastName);
        prepStmt.setString(6, customerDOB);
        prepStmt.setString(7, customerPhone);
        prepStmt.executeUpdate();

        rs = prepStmt.getGeneratedKeys();
        int customerID;
        if (rs.next()) {
            customerID = rs.getInt(1);
        } else {
            throw new SQLException("Creating order failed, no ID obtained.");
        }
        UserAccountDBManager userDB = new UserAccountDBManager(conn);
        userDB.createAccount(customerID);
        prepStmt.close();
        conn.close();


    }
    public Customer findCustomer(String email, String password) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMEREMAIL = ? AND CUSTOMERPASSWORD = ?;");
        prepStmt.setString(1, email);
        prepStmt.setString(2, password);

        ResultSet rs = prepStmt.executeQuery();
        while(rs.next()) {
            String customerEmail = rs.getString("customerEmail");
            String customerPassword = rs.getString("customerPassword");
            if (email.equals(customerEmail) && password.equals(customerPassword)) {
                int id = rs.getInt("customerID");
                int regID = rs.getInt("registrationID");
                String fName = rs.getString("customerFirstName");
                String lName = rs.getString("customerLastName");
                String dob = rs.getString("customerDOB");
                String phone = rs.getString("customerPhone");
                prepStmt.close();
                return new Customer(id, regID, customerEmail, customerPassword, fName, lName, dob, phone);
            }
        }
        prepStmt.close();
        return null;
    }
    public ArrayList<Customer> getCustomers() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
        ArrayList<Customer> temp = new ArrayList<>();

        while(rs.next()) {
            int ID = rs.getInt("customerID");
            int registrationID = rs.getInt("registrationID");
            String email = rs.getString("customerEmail");
            String password = rs.getString("customerPassword");
            String fName = rs.getString("customerFirstName");
            String lName = rs.getString("customerLastName");
            String dob = rs.getString("customerDOB");
            String phone = rs.getString("customerPhone");
            temp.add(new Customer(ID, registrationID, email, password, fName, lName, dob, phone));
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
