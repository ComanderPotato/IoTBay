package iotbay.model;

import java.io.Serializable;

public class OrderLineItem implements Serializable {
    private int itemID;
    private int productID;
    private int itemQuantity;
    private double itemTotal;
    public OrderLineItem() {

    }

    public OrderLineItem(int itemQuantity, double itemTotal) {
        this.itemQuantity = itemQuantity;
        this.itemTotal = itemTotal;
    }

    public OrderLineItem(
            int itemID,
            int productID,
            int itemQuantity,
            double itemTotal
    ) {
        this.itemID = itemID;
        this.productID = productID;
        this.itemQuantity = itemQuantity;
        this.itemTotal = itemTotal;
    }

    public int getItemID() {
        return itemID;
    }

     public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

}
