package iotbay.model.dao;
import iotbay.model.Customer;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
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
}
