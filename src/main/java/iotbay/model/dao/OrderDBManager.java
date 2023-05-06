package iotbay.model.dao;
import iotbay.model.Order;
import java.sql.*;
import java.util.ArrayList;
public class OrderDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    public OrderDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

}
