package iotbay.model.dao;
import iotbay.model.UserAccount;
import java.sql.*;
import iotbay.model.dao.CartDBManager;
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
            if(rs.getInt("userAccountID") == userAccountID) {
                int customerID = rs.getInt("customerID");
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
    public void createAccount(int customerID) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO USERACCOUNT (CUSTOMERID) VALUES (?)");
        prepStmt.setInt(1, customerID);
        prepStmt.executeUpdate();

        rs = prepStmt.getGeneratedKeys();
        int accountID;
        if (rs.next()) {
            accountID = rs.getInt(1);
        } else {
            throw new SQLException("Creating order failed, no ID obtained.");
        }

        CartDBManager cartDB = new CartDBManager(conn);
        int cartID = cartDB.createCart(accountID);
        prepStmt = conn.prepareStatement("UPDATE USERACCOUNT SET CARTID = ? WHERE USERACCOUNTID = ?");
        prepStmt.setInt(1, cartID);
        prepStmt.setInt(2, accountID);
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();

    }
    public void deleteAccount(int userAccountID) throws SQLException {

    }
}