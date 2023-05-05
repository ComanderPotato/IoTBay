package iotbay.model.dao;
import iotbay.model.AccountManagement;
import iotbay.model.UserAccount;
import java.sql.*;
import java.util.ArrayList;
public class AccountManagementDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    public AccountManagementDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public UserAccount findAccount(String userAccountID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USERACCOUNT WHERE ID='?';");
        prepStmt.setString(1, userAccountID);
        ResultSet rs = prepStmt.executeQuery();
        while(rs.next()) {
            int foundID = rs.getInt("userAccountID");
            if(userAccountID.equals(foundID)) {
                UserAccount user = new UserAccount();
                user.setUserAccountID(foundID);
                user.setCustomerID(rs.getInt("customerID"));
                user.setRegistrationID(rs.getInt("registrationID"));
                user.setPaymentID(rs.getInt("paymentID"));
                user.setOrderHistoryID(rs.getInt("orderHistoryID"));
                user.setOrderID(rs.getInt("orderID"));
                user.setOrderTrackingID(rs.getInt("orderTrackingID"));
                user.setAddressID(rs.getInt("addressID"));
                user.setCardID(rs.getInt("cartID"));
                return user;
            }
        }
        return null;
    }
    public void resetPassword() throws SQLException {

    }
    public void createAccount() throws SQLException {

    }
    public void deleteAccount() throws SQLException {

    }
}
