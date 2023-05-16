package iotbay.model.dao;
import iotbay.model.Order;
import iotbay.model.Product;
import iotbay.model.OrderLineItem;
import java.sql.*;
import java.util.ArrayList;

public class OrderHistoryDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet rs;

    public OrderHistoryDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

}