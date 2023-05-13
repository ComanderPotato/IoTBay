package iotbay.model.dao;

import java.sql.*;

/*
 * DBManager is the primary DAO class to interact with the database.
 * Complete the existing methods of this classes to perform CRUD operations with the db.
 */

public class DBManager {
    private Statement st;
    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

}