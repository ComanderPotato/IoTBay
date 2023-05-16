package iotbay.model.dao;
import iotbay.model.Registration;
import iotbay.model.dao.CustomerDBManager;
import java.sql.*;
import java.time.LocalDateTime;

public class RegistrationDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet rs;

    public RegistrationDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public void register(String firstName, String lastName, String DOB, String phoneNo, String email, String password) throws SQLException{
        prepStmt = conn.prepareStatement("INSERT INTO REGISTRATION " +
                "(FIRSTNAME, LASTNAME, DOB, PHONENO, EMAIL, PASSWORD, DATEREGISTERED)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);");
        prepStmt.setString(1, firstName);
        prepStmt.setString(2, lastName);
        prepStmt.setString(3, DOB);
        prepStmt.setString(4, phoneNo);
        prepStmt.setString(5, email);
        prepStmt.setString(6, password);
        prepStmt.setString(7, "now");
        prepStmt.executeUpdate();

        CustomerDBManager customerDB = new CustomerDBManager(conn);
        rs = prepStmt.getGeneratedKeys();
        int registerID;

        if(rs.next()) {
            registerID = rs.getInt(1);
        } else {
            throw new SQLException("Creating user failed, no ID obtained.");
        }
        customerDB.addCustomer(registerID, email, password, firstName, lastName, DOB, phoneNo);
        prepStmt.close();

        rs.close();
        conn.close();

    }
}