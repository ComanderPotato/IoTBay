package iotbay.model.dao;
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

    public void addItem(String productID) throws SQLException {

    }

    public void updateItem() throws SQLException {

    }

    public void findItem(String productID) throws SQLException {

    }

    public ArrayList<OrderLineItem> getItems() {
        ArrayList<OrderLineItem> temp = new ArrayList<>();
        return temp;
    }
}
