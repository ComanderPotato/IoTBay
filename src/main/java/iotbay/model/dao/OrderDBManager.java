package iotbay.model.dao;
import iotbay.model.Order;
import iotbay.model.OrderLineItem;
import iotbay.model.UserAccount;
import jakarta.json.JsonObject;

import java.sql.*;
import java.util.ArrayList;

public class OrderDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private PreparedStatement itemPrepStmt;
    private Connection conn;
    private ResultSet rs;
    private ResultSet itemRs;
    public OrderDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public void createOrder(UserAccount userAccount, ArrayList<OrderLineItem> orderLineItems) throws SQLException {
        // Is itemTotal already calculated as the sum of price * quantity?
        double total = orderLineItems.stream().mapToDouble(i -> i.getItemTotal()).sum();
        prepStmt = conn.prepareStatement("INSERT INTO \"ORDER\" " +
                "(userAccountID, addressID, paymentID, orderTotal, orderDate, orderStatus)" +
                "VALUES (?, ?, ?, ?, ?, ?)");
        prepStmt.setInt(1, userAccount.getUserAccountID());
        prepStmt.setInt(2, userAccount.getAddressID());
        prepStmt.setInt(3, userAccount.getPaymentID());
        prepStmt.setDouble(4, total);
        prepStmt.setString(5, "Pending"); // Placeholder
        prepStmt.executeUpdate();

        rs = prepStmt.getGeneratedKeys();
        int orderID = rs.getInt(1);

        prepStmt = conn.prepareStatement("INSERT INTO ORDERLINEITEM (ITEMID, ORDERID, PRODUCTID, ITEMQUANTITY, ITEMTOTAL)" +
                "VALUES (?, ?, ?, ?, ?)");

        for(OrderLineItem lineItem : orderLineItems) {
            prepStmt.setInt(1, lineItem.getItemID());
            prepStmt.setInt(2, orderID);
            prepStmt.setInt(3, lineItem.getProductID());
            prepStmt.setInt(4, lineItem.getItemQuantity());
            prepStmt.setDouble(5, lineItem.getItemTotal());
            prepStmt.executeUpdate();
        }
        conn.commit();
        prepStmt.close();
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
    public void addItem(String orderID, OrderLineItem item) throws SQLException {

    }
    public void removeItem(String orderID, OrderLineItem item) throws SQLException {

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
            itemPrepStmt = conn.prepareStatement("SELECT * FROM ORDERLINEITEMS WHERE ORDERID = ?");
            itemPrepStmt.setInt(1, orderID);
            ArrayList<OrderLineItem> orderItems = new ArrayList<>();
            itemRs = itemPrepStmt.executeQuery();
            OrderLineItemDBManager.getOrderLineItems(orderItems, itemRs);
            temp.add(new Order(orderID, userAccountID, addressID, paymentID, orderTotal, orderDate, orderStatus, orderItems));
        }
        rs.close();
        prepStmt.close();
        conn.close();
        return temp;
    }
}
