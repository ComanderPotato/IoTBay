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

    public void createProduct(Product product) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO PRODUCT " +
                "(PRODUCTCATEGORY, IMAGEURL, PRODUCTNAME, PRODUCTDESCRIPTION, " +
                "PRODUCTCOST, PRODUCTAVAILABILITY, PRODUCTQUANTITY, PRODUCTBRAND)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        prepStmt.setString(1, product.getProductCategory());
        prepStmt.setString(2, product.getImageURL());
        prepStmt.setString(3, product.getProductName());
        prepStmt.setString(4, product.getProductDescription());
        prepStmt.setDouble(5, product.getProductCost());
        prepStmt.setBoolean(6, product.isProductAvailable());
        prepStmt.setInt(7, product.getProductQuantity());
        prepStmt.setString(8, product.getProductBrand());
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }
    public void deleteProduct(int productID) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE PRODUCT WHERE PRODUCTID = ?");
        prepStmt.setInt(1, productID);
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.close();
    }
    public void updateProduct(Product product) throws SQLException {
        prepStmt = conn.prepareStatement("UPDATE PRODUCT" +
                "SET PRODUCTCATEGORY = ?, IMAGEURL = ?, PRODUCTNAME = ?, PRODUCTDESCRIPTION = ?," +
                "PRODUCTCOST = ?, PRODUCTAVAILABILITY = ?, PRODUCTQUANTITY = ?, PRODUCTBRAND = ?" +
                                                 "WHERE PRODUCTID = ?");
        prepStmt.setString(1, product.getProductCategory());
        prepStmt.setString(2, product.getImageURL());
        prepStmt.setString(3, product.getProductName());
        prepStmt.setString(4, product.getProductDescription());
        prepStmt.setDouble(5, product.getProductCost());
        prepStmt.setBoolean(6, product.isProductAvailable());
        prepStmt.setInt(7, product.getProductQuantity());
        prepStmt.setString(8, product.getProductBrand());
        prepStmt.setInt(9, product.getProductID());
        prepStmt.executeUpdate();
        prepStmt.close();
        conn.commit();
    }
    public ArrayList<Product> fetchProducts() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM PRODUCT");
        ArrayList<Product> temp = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            temp.add(new Product(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDouble(6),
                    rs.getBoolean(7),
                    rs.getInt(8),
                    rs.getString(9))
            );
        }
        rs.close();
        prepStmt.close();
        conn.close();
        return temp;
    }
//    public ArrayList<Product> findProductsByName(String productName) throws SQLException {
//        prepStmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCTNAME = ?");
//        prepStmt.setString(1, productName);
//        ArrayList<Product> temp = new ArrayList<>();
//        rs = prepStmt.executeQuery();
//        while(rs.next()) {
//            if(rs.getString("productName").equals(productName)) {
//                int productID = rs.getInt("productID");
//                String productCategory = rs.getString("productCategory");
//                String imageURL = rs.getString("imageURL");
//                String productDescription = rs.getString("productDescription");
//                double productCost = rs.getDouble("productCost");
//                boolean productAvailability = rs.getBoolean("productAvailability");
//                int productQuantity = rs.getInt("productQuantity");
//                String productBrand = rs.getString("productBrand");
//                temp.add(new Product(productID, productCategory, imageURL, productName, productDescription, productCost, productAvailability, productQuantity, productBrand));
//            }
//        }
//        rs.close();
//        prepStmt.close();
//        conn.close();
//        return temp;
//    }
    public ArrayList<Product> findProductsByCategory(String productCategory) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCTNAME = ?");
        prepStmt.setString(1, productCategory);
        ArrayList<Product> temp = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            if(rs.getString("productCategory").equals(productCategory)) {
                int productID = rs.getInt(1);
                String imageURL = rs.getString(3);
                String productName = rs.getString(4);
                String productDescription = rs.getString(5);
                double productCost = rs.getDouble(6);
                boolean productAvailability = rs.getBoolean(7);
                int productQuantity = rs.getInt(8);
                String productBrand = rs.getString(9);
                temp.add(new Product(productID, productCategory, imageURL, productName, productDescription, productCost, productAvailability, productQuantity, productBrand));
            }
        }
        rs.close();
        prepStmt.close();
        conn.close();
        return temp;
    }
//    public ArrayList<Product> getProducts() throws SQLException {
//        prepStmt = conn.prepareStatement("SELECT * FROM PRODUCT");
//        ArrayList<Product> temp = new ArrayList<>();
//        rs = prepStmt.executeQuery();
//        while(rs.next()) {
//            int productID = rs.getInt("productID");
//            String productCategory = rs.getString("productCategory");
//            String imageURL = rs.getString("imageURL");
//            String productName = rs.getString("productName");
//            String productDescription = rs.getString("productDescription");
//            double productCost = rs.getDouble("productCost");
//            boolean productAvailability = rs.getBoolean("productAvailability");
//            int productQuantity = rs.getInt("productQuantity");
//            String productBrand = rs.getString("productBrand");
//            temp.add(new Product(productID, productCategory, imageURL, productName, productDescription, productCost, productAvailability, productQuantity, productBrand));
//        }
//        rs.close();
//        prepStmt.close();
//        conn.close();
//        return temp;
//    }
}
