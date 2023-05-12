package iotbay.controller;
import iotbay.model.OrderLineItem;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.OrderLineItemDBManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderLineItemController {
    private DBConnector connector;
    private Connection conn;
    private OrderLineItemDBManager db;
    public OrderLineItemController() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new OrderLineItemDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}