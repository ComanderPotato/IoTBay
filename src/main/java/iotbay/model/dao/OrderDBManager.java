package iotbay.model.dao;
import iotbay.model.Order;
import iotbay.model.OrderLineItem;
import jakarta.json.JsonObject;

import java.sql.*;
import java.util.ArrayList;

public class OrderDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet rs;
    public OrderDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public void createOrder(String customerID, ArrayList<OrderLineItem> orderLineItems) throws SQLException {

    }
    public void deleteOrder(int orderID) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE FROM ORDER WHERE ID = ?");
        prepStmt.setInt(1, orderID);
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }
    public void updateStatus(String status, int orderID) throws SQLException {
        prepStmt = conn.prepareStatement("UPDATE ORDER SET ORDERSTATUS = ? WHERE ORDERID = ?");
        prepStmt.setString(1, status);
        prepStmt.setInt(2, orderID);
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }
    public void addItem(OrderLineItem item) throws SQLException {

    }
    public void removeItem(OrderLineItem item) throws SQLException {

    }

    public double orderTotal(int orderID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM ORDER WHERE ORDERID = ?");
        prepStmt.setInt(1, orderID);

        rs = prepStmt.executeQuery();
        double temp = 0.0;
        while(rs.next()) {
            if(rs.getInt("orderID") == orderID) {
                temp = rs.getDouble("orderTotal");
            }
        }
        rs.close();
        prepStmt.close();
        conn.close();
        return temp;
    }


    // Should this get orders only for a specific user or all of them? Still a WIP
    public ArrayList<Order> getOrders() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM ORDER");
        ArrayList<Order> temp = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            int orderID = rs.getInt("orderID");
            int orderLineID = rs.getInt("orderLineID");
            int userAccountID = rs.getInt("userAccountID");
            int addressID = rs.getInt("addressID");
            int paymentID = rs.getInt("paymentID");
            double orderTotal = rs.getDouble("orderTotal");
            String orderDate = rs.getString("orderDate");
            String orderStatus = rs.getString("orderStatus");
            temp.add(new Order(orderID, orderLineID, userAccountID, addressID, paymentID, orderTotal, orderDate, orderStatus));
        }
        rs.close();
        prepStmt.close();
        conn.close();
        return temp;
    }
}
