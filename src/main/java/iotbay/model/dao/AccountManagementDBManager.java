package iotbay.model.dao;
import iotbay.model.AccountManagement;
import iotbay.model.UserAccount
import java.sql.*;
import java.util.ArrayList;
public class AccountManagementDBManager {
    private Statement stmt;
    public AccountManagementDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
    }

    public UserAccount findAccount(String userAccountID) throws SQLException {
        String sql = "SELECT * FROM USERACCOUNT WHERE ID='" + userAccountID + "';";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            String id = rs.getString("")
        }
    }
}
