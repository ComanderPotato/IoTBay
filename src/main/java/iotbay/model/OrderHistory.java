package iotbay.model;

import java.io.Serializable;

public class OrderHistory implements Serializable {
    private int orderHistoryID;
    private int invoiceID;

    public OrderHistory() {
    }

    public OrderHistory(int orderHistoryID, int invoiceID) {
        this.orderHistoryID = orderHistoryID;
        this.invoiceID = invoiceID;
    }

    public int getOrderHistoryID() {
        return orderHistoryID;
    }

    public void setOrderHistoryID(int orderHistoryID) {
        this.orderHistoryID = orderHistoryID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }
}
