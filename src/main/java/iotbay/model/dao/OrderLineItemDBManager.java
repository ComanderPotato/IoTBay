package iotbay.model.dao;
import iotbay.model.Order;
import iotbay.model.OrderLineItem;
import java.sql.*;
import java.util.ArrayList;

public class OrderLineItemDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet rs;
    public OrderLineItemDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public void addItem(int productID) throws SQLException {

    }

    public void updateItem() throws SQLException {

    }

    //Is this returning products or orderlineitems?
    public ArrayList<OrderLineItem> findItem(int productID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM ORDERLINEITEMS WHERE PRODUCTID = ?");
        prepStmt.setInt(1, productID);

        rs = prepStmt.executeQuery();
        ArrayList<OrderLineItem> temp = new ArrayList<>();
        getOrderLineItems(temp, rs);
        rs.close();
        prepStmt.close();
        conn.close();
        return temp;
    }

    // Is this getting all items in the database or all items in an order?
    public ArrayList<OrderLineItem> getItems() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM ORDERLINEITEMS");

        rs = prepStmt.executeQuery();
        ArrayList<OrderLineItem> temp = new ArrayList<>();
        getOrderLineItems(temp, rs);
        return temp;
    }

    static void getOrderLineItems(ArrayList<OrderLineItem> temp, ResultSet rs) throws SQLException {
        while(rs.next()) {
            int itemID = rs.getInt("itemID");
            int orderID = rs.getInt("orderID");
            int productID = rs.getInt("productID");
            int itemQuantity = rs.getInt("itemQuantity");
            double itemTotal = rs.getDouble("itemTotal");
            temp.add(new OrderLineItem(itemID, orderID, productID, itemQuantity, itemTotal));
        }
    }
}
