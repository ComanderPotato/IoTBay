package iotbay.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String productName;
    private String productCategory;
    private String imageURL;
    private String productDescription;
    private double productCost;
    private int productQuantity;

    public Product() {
    }

    public Product(
            String productName,
            String productCategory,
            String imageURL,
            String productDescription,
            double productCost,
            int productQuantity
    ) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.imageURL = imageURL;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productQuantity = productQuantity;
    }

    public Product(
            int productID,
            String productName,
            String productCategory,
            String imageURL,
            String productDescription,
            double productCost,
            int productQuantity
    ) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.imageURL = imageURL;
        this.productDescription = productDescription;
        this.productCost = productCost;
        this.productQuantity = productQuantity;
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


    public String getProductDescription() {
        return productDescription;
    }


    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }



    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }


}
