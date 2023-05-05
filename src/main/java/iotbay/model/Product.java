package iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String productCategory;
    private String imageURL;
    private String productName;
    private String productDescription;
    private double productCost;
    private boolean productAvailability;
    private int productQuantity;
    private String productBrand;

    public Product() {
    }

    public Product(
            String productCategory,
            String imageURL,
            String productName,
            String productDescription,
            double productCost,
            boolean productAvailability,
            int productQuantity,
            String productBrand
    ) {
        this.productCategory = productCategory;
        this.imageURL = imageURL;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productAvailability = productAvailability;
        this.productQuantity = productQuantity;
        this.productBrand = productBrand;
    }

    public Product(
            int productID,
            String productCategory,
            String imageURL,
            String productName,
            String productDescription,
            double productCost,
            boolean productAvailability,
            int productQuantity,
            String productBrand
    ) {
        this.productID = productID;
        this.productCategory = productCategory;
        this.imageURL = imageURL;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productAvailability = productAvailability;
        this.productQuantity = productQuantity;
        this.productBrand = productBrand;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public boolean isProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(boolean productAvailability) {
        this.productAvailability = productAvailability;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
}
