package iotbay.model;

import java.io.Serializable;

public class Order implements Serializable {
    private int orderID;
    private int orderLineItemID;
    private int userAccountID;
    private int addressID;
    private int paymentID;
    private double orderTotal;
    private String orderDate;
    private String orderStatus;
    public Order() {

    }

    public int getOrderID() {
        return orderID;
    }

    public Order(double orderTotal, String orderDate, String orderStatus) {
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Order(
            int orderID,
            int orderLineItemID,
            int userAccountID,
            int addressID,
            int paymentID,
            double orderTotal,
            String orderDate,
            String orderStatus
    ) {
        this.orderID = orderID;
        this.orderLineItemID = orderLineItemID;
        this.userAccountID = userAccountID;
        this.addressID = addressID;
        this.paymentID = paymentID;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderLineItemID() {
        return orderLineItemID;
    }

    public void setOrderLineItemID(int orderLineItemID) {
        this.orderLineItemID = orderLineItemID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
