package iotbay.model;

import java.io.Serializable;

public class OrderLineItem implements Serializable {
    private int itemID;
    private int orderID;
    private int productID;
    private int itemQuantity;
    private double itemTotal;
    public OrderLineItem() {

    }

    public OrderLineItem(int productID, int itemQuantity, double itemTotal) {
        this.productID = productID;
        this.itemQuantity = itemQuantity;
        this.itemTotal = itemTotal;
    }

    public OrderLineItem(
            int itemID,
            int orderID,
            int productID,
            int itemQuantity,
            double itemTotal
    ) {
        this.itemID = itemID;
        this.orderID = orderID;
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

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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
