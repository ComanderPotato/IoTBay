package iotbay.model.dao;
import iotbay.model.UserAccount;
import java.sql.*;
import java.util.ArrayList;

public class UserAccountDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet rs;

    public UserAccountDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public UserAccount findAccount(int userAccountID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USERACCOUNT WHERE ACCOUNTID = ?");
        prepStmt.setInt(1, userAccountID);

        rs = prepStmt.executeQuery();

        while(rs.next()) {
            if(rs.getInt("ACCOUNTID") == userAccountID) {
                int customerID = rs.getInt("customerID");
                int registrationID = rs.getInt("registrationID");
                int paymentID = rs.getInt("paymentID");
                int orderHistoryID = rs.getInt("orderHistoryID");
                int orderID = rs.getInt("orderID");
                int orderTrackingID = rs.getInt("orderTrackingID");
                int addressID = rs.getInt("addressID");
                int cartID = rs.getInt("cartID");
                return new UserAccount(userAccountID, customerID, registrationID, paymentID, orderHistoryID, orderID, orderTrackingID, addressID, cartID);
            }
        }
        return null;
    }
    public void createAccount() throws SQLException {

    }
    public void deleteAccount(int userAccountID) throws SQLException {
    }
}