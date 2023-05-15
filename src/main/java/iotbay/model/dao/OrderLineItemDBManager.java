package iotbay.model.dao;
import iotbay.model.Order;
import iotbay.model.Product;
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

    public void createOrderLineItem(int orderID, Product product, int itemQuantity) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO ORDERLINEITEMS " +
                "(ORDERID, PRODUCTID, ITEMQUANTITY, ITEMTOTAL)" +
                "VALUES (?, ?, ?, ?)");
        prepStmt.setInt(1, orderID);
        prepStmt.setInt(2, product.getProductID());
        prepStmt.setInt(3, itemQuantity);
        prepStmt.setDouble(4, product.getProductCost());
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }

    public void updateOrderLineItem(int itemID, int itemQuantity) throws SQLException {
        prepStmt = conn.prepareStatement("UPDATE ORDERLINEITEM SET ITEMQUANTITY = ? WHERE ITEMID = ?");
        prepStmt.setInt(1, itemQuantity);
        prepStmt.setInt(2, itemID);
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }
    public void deleteOrderLIneItem(int itemID) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE ORDERLINEITEM WHERE ITEMID = ?");
        prepStmt.setInt(1, itemID);
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }
    public ArrayList<OrderLineItem> fetchOrderLineItems(int itemID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM ORDERLINEITEM WHERE ITEMID = ?");
        prepStmt.setInt(1, itemID);

        rs = prepStmt.executeQuery();
        ArrayList<OrderLineItem> temp = new ArrayList<>();

        while(rs.next()) {
            if(rs.getInt(1) == itemID) {
                int orderID = rs.getInt(2);
                int productID = rs.getInt(3);
                int itemQuantity = rs.getInt(4);
                double itemTotal = rs.getDouble(5);
                temp.add(new OrderLineItem(itemID, orderID, productID, itemQuantity, itemTotal));
            }
        }
        return temp;
    }
//    public void updateItem(int itemID, int newQuantity) throws SQLException {
//
//    }
//
//    //Is this returning products or orderlineitems?
//    public ArrayList<OrderLineItem> findItem(int productID) throws SQLException {
//        prepStmt = conn.prepareStatement("SELECT * FROM ORDERLINEITEMS WHERE PRODUCTID = ?");
//        prepStmt.setInt(1, productID);
//
//        rs = prepStmt.executeQuery();
//        ArrayList<OrderLineItem> temp = new ArrayList<>();
//        getOrderLineItems(temp, rs);
//        rs.close();
//        prepStmt.close();
//        conn.close();
//        return temp;
//    }
//
//    // Is this getting all items in the database or all items in an order?
//    public ArrayList<OrderLineItem> getItems() throws SQLException {
//        prepStmt = conn.prepareStatement("SELECT * FROM ORDERLINEITEMS");
//
//        rs = prepStmt.executeQuery();
//        ArrayList<OrderLineItem> temp = new ArrayList<>();
//        getOrderLineItems(temp, rs);
//        return temp;
//    }
//
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
