package iotbay.controller;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.UserAccountDBManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAccountController {
    private DBConnector connector;
    private Connection conn;
    private UserAccountDBManager db;
    public UserAccountController() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new UserAccountDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}