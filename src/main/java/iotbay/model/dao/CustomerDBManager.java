package iotbay.model.dao;
import iotbay.model.Customer;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDBManager {
    private Statement stmt;

    public CustomerDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
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
        stmt.executeUpdate(String.format("INSERT INTO CUSTOMER "
                        + "(customerEmail, customerPassword, customerFirstName, " +
                        "customerLastName, customerDOB, customerPhone)"
                        + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
                customerEmail, customerPassword, customerFirstName,
                customerLastName, customerDOB, customerPhone));
    }
    public void deleteCustomer(String email) throws SQLException {
        stmt.executeUpdate("DELETE FROM CUSTOMER WHERE EMAIL='" + email + "';");
    }
    public Customer findCustomer(String email, String password) throws SQLException {
        String sql = "SELECT * FROM CUSTOMER WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "';";
        ResultSet rs = stmt.executeQuery(sql);
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
    public ArrayList<Customer> fetchCustomers() throws SQLException {
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
