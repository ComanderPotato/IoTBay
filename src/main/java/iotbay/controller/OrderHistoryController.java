package iotbay.controller;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.OrderLineItemDBManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderHistoryController {
    private DBConnector connector;
    private Connection conn;
    private OrderLineItemDBManager db;
    public OrderHistoryController() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new OrderLineItemDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrderHistoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
