package iotbay.controller;
import iotbay.model.dao.DBConnector;
import iotbay.model.dao.RegistrationDBManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationController {
    private DBConnector connector;
    private Connection conn;
    private RegistrationDBManager db;
    public RegistrationController() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new RegistrationDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
