package iotbay.controller;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.ProductDBManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductController {
    private DBConnector connector;
    private Connection conn;
    private ProductDBManager db;
    public ProductController() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new ProductDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}