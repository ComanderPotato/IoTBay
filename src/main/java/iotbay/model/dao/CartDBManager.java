package iotbay.model.dao;
import iotbay.model.CartItem;
import iotbay.model.Order;
import iotbay.model.OrderLineItem;
import iotbay.model.UserAccount;
import java.sql.*;
import java.util.ArrayList;

public class CartDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private PreparedStatement itemPrepStmt;
    private Connection conn;
    private ResultSet rs;
    private ResultSet itemRs;

    public CartDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public int createCart(int userAccountID) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO CART (USERACCOUNTID) VALUES (?)");
        prepStmt.setInt(1, userAccountID);
        prepStmt.executeUpdate();

        rs = prepStmt.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new SQLException("Creating order failed, no ID obtained.");
        }
    }
}
