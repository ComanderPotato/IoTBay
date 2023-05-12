package iotbay.model.dao;
import iotbay.model.Product;
import java.sql.*;
import java.util.ArrayList;

public class ProductDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    private ResultSet rs;
    public ProductDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }

    public void addProduct(Product product) throws SQLException {

    }
    public void removeProduct(Product product) throws SQLException {

    }
    public void updateProduct(Product product) throws SQLException {

    }
    public void viewProduct(Product product) throws SQLException {

    }
    public void findProductByName(String productName) throws SQLException {

    }
    public void findProductByCategory(String productCategory) throws SQLException {

    }
    public ArrayList<Product> getProducts() throws SQLException {
        ArrayList<Product> temp = new ArrayList<>();
        return temp;
    }

}
