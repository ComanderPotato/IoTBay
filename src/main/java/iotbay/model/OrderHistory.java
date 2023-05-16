package iotbay.model;

import java.io.Serializable;

public class OrderHistory implements Serializable {
    private int orderHistoryID;
    private int orderID;

    public OrderHistory() {
    }

    public OrderHistory(int orderHistoryID, int orderID) {
        this.orderHistoryID = orderHistoryID;
        this.orderID = orderID;
    }

    public int getOrderHistoryID() {
        return orderHistoryID;
    }

    public void setOrderHistoryID(int orderHistoryID) {
        this.orderHistoryID = orderHistoryID;
    }

    public int getInvoiceID() {
        return orderID;
    }

    public void setInvoiceID(int invoiceID) {
        this.orderID = orderID;
    }
}
