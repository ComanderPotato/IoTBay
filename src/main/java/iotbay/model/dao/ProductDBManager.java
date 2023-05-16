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
        prepStmt = conn.prepareStatement("INSERT INTO PRODUCT " +
                "(PRODUCTCATEGORY, IMAGEURL, PRODUCTNAME, PRODUCTDESCRIPTION, " +
                "PRODUCTCOST, PRODUCTAVAILABILITY, PRODUCTQUANTITY, PRODUCTBRAND)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        prepStmt.setString(1, product.getProductName());
        prepStmt.setString(2, product.getProductCategory());
        prepStmt.setString(3, product.getImageURL());
        prepStmt.setString(4, product.getProductDescription());
        prepStmt.setDouble(5, product.getProductCost());
        prepStmt.setInt(6, product.getProductQuantity());
        prepStmt.executeUpdate();
    }
    public void deleteProduct(String productName) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE PRODUCT WHERE PRODUCTNAME = ?");
        prepStmt.setString(1, productName);
        prepStmt.executeUpdate();
    }
    public void updateProduct(String name, Product product) throws SQLException {
        prepStmt = conn.prepareStatement("UPDATE PRODUCT" +
                "SET PRODUCTCATEGORY = ?, IMAGEURL = ?, PRODUCTNAME = ?, PRODUCTDESCRIPTION = ?," +
                "PRODUCTCOST = ?, PRODUCTAVAILABILITY = ?, PRODUCTQUANTITY = ?, PRODUCTBRAND = ?" +
                                                 "WHERE PRODUCTNAME = ?");
        prepStmt.setString(1, product.getProductName());
        prepStmt.setString(2, product.getProductCategory());
        prepStmt.setString(3, product.getImageURL());
        prepStmt.setString(4, product.getProductDescription());
        prepStmt.setDouble(5, product.getProductCost());
        prepStmt.setInt(6, product.getProductQuantity());
        prepStmt.setString(7, name);
        prepStmt.executeUpdate();
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
                    rs.getInt(7)
            ));
        }
        return temp;
    }
    public Product findProduct(int productID) throws SQLException {
            prepStmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCTID = ?");
            prepStmt.setInt(1, productID);
            rs = prepStmt.executeQuery();
            while(rs.next()) {
                if(rs.getInt("productID") == productID) {
                    String productCategory = rs.getString(2);
                    String imageURL = rs.getString(3);
                    String productName = rs.getString(4);
                    String productDescription = rs.getString(5);
                    double productCost = rs.getDouble(6);
                    boolean productAvailability = rs.getBoolean(7);
                    int productQuantity = rs.getInt(8);
                    String productBrand = rs.getString(9);
                    return new Product(productID, productName, productCategory, imageURL, productDescription, productCost, productQuantity);
                }
            }
            return null;
    }

public ArrayList<Product> fetchItemsByCategory(String name, String category) throws SQLException {
    ArrayList<Product> temp = new ArrayList<>();
    ResultSet rs;
    String fetch;

    if (category.equals("All")) {
        fetch =  "SELECT * FROM PRODUCT WHERE LOWER(productName) LIKE '%" + name + "%'";
    } else {
        fetch = "SELECT * FROM PRODUCT WHERE LOWER(productName) LIKE '%" + name + "%' AND productCategory = '" + category + "';";
    }

    rs = prepStmt.executeQuery(fetch);

    while (rs.next()) {
        int itemID = rs.getInt(1);
        String itemName = rs.getString(2);
        String itemCategory = rs.getString(3);
        String itemImage = rs.getString(4);
        String itemDescription = rs.getString(5);
        double itemCost = rs.getDouble(6);
        int itemQuantity = rs.getInt(7);
        temp.add(new Product(itemID, itemName, itemCategory, itemImage, itemDescription, itemCost, itemQuantity));
    }
    return temp;
}
    public ArrayList<ArrayList<String>> fetchCategories() throws SQLException {
        String fetchAll = "SELECT COUNT(*) FROM PRODUCT";
        ResultSet rsCount = prepStmt.executeQuery(fetchAll);
        int allCount = 0;
        if (rsCount.next()) {
            allCount = rsCount.getInt(1);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> all = new ArrayList<>();

        all.add("All");
        all.add(Integer.toString(allCount));
        result.add(all);

        //fetch stored categories and counts
        String fetch = "SELECT productCategory, COUNT(*) FROM PRODUCT GROUP BY productCategory";
        ResultSet rs = prepStmt.executeQuery(fetch);

        while (rs.next()) {
            String itemCategory = rs.getString(1);
            int count = rs.getInt(2);
            ArrayList<String> temp = new ArrayList<>();

            temp.add(itemCategory);
            temp.add(Integer.toString(count));
            result.add(temp);
        }
        return result;
    }
    public ArrayList<Product> sortItems(String sort, String category) throws SQLException {
        String fetch;

        switch (sort) {
            case "Price low to high":
                if (category.equals("All")) {
                    fetch = "SELECT * FROM PRODUCT ORDER BY productCost ASC";
                } else {
                    fetch = "SELECT * FROM PRODUCT WHERE productcategory = '" + category + "' ORDER BY productCost ASC";
                }
                break;
            case "Price high to low":
                if (category.equals("All")) {
                    fetch = "SELECT * FROM PRODUCT ORDER BY productCost DESC";
                } else {
                    fetch = "SELECT * FROM PRODUCT WHERE productcategory = '" + category + "' ORDER BY productCost DESC";
                }
                break;
            case "In stock low to high":
                if (category.equals("All")) {
                    fetch = "SELECT * FROM PRODUCT ORDER BY productQuantity ASC";
                } else {
                    fetch = "SELECT * FROM PRODUCT WHERE productcategory = '" + category + "' ORDER BY productQuantity ASC";
                }
                break;
            case "In stock high to low":
                if (category.equals("All")) {
                    fetch = "SELECT * FROM PRODUCT ORDER BY productQuantity DESC";
                } else {
                    fetch = "SELECT * FROM PRODUCT WHERE productcategory = '" + category + "' ORDER BY productQuantity DESC";
                }
                break;
            default:
                if (category.equals("All")) {
                    fetch = "SELECT * FROM PRODUCT ORDER BY productCategory ASC";
                } else {
                    fetch = "SELECT * FROM PRODUCT WHERE productcategory = '" + category + "' ORDER BY productCategory ASC";
                }
                break;
        }

        ResultSet rs = prepStmt.executeQuery(fetch);
        ArrayList<Product> temp = new ArrayList<>();

        while (rs.next()) {
            int itemID = rs.getInt(1);
            String itemName = rs.getString(2);
            String itemCategory = rs.getString(3);
            String itemImage = rs.getString(4);
            String itemDescription = rs.getString(5);
            double itemCost = rs.getDouble(6);
            int itemQuantity = rs.getInt(7);
            temp.add(new Product(itemID, itemName, itemCategory, itemImage, itemDescription, itemCost, itemQuantity));
        }
        return temp;
    }
}
