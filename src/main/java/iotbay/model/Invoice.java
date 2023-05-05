package iotbay.model;

import java.io.Serializable;
public class Invoice implements Serializable {
    private int invoiceID;
    private int userAccountID;
    private int orderID;
    private int paymentID;
    private String orderDate;
    private String issueDate;
    private double invoiceDiscount;
    private double invoiceTax;

    public Invoice() {
    }

    public Invoice(
            String orderDate,
            String issueDate,
            double invoiceDiscount,
            double invoiceTax
    ) {
        this.orderDate = orderDate;
        this.issueDate = issueDate;
        this.invoiceDiscount = invoiceDiscount;
        this.invoiceTax = invoiceTax;
    }

    public Invoice(
            int invoiceID,
            int userAccountID,
            int orderID,
            int paymentID,
            String orderDate,
            String issueDate,
            double invoiceDiscount,
            double invoiceTax
    ) {
        this.invoiceID = invoiceID;
        this.userAccountID = userAccountID;
        this.orderID = orderID;
        this.paymentID = paymentID;
        this.orderDate = orderDate;
        this.issueDate = issueDate;
        this.invoiceDiscount = invoiceDiscount;
        this.invoiceTax = invoiceTax;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public double getInvoiceDiscount() {
        return invoiceDiscount;
    }

    public void setInvoiceDiscount(double invoiceDiscount) {
        this.invoiceDiscount = invoiceDiscount;
    }

    public double getInvoiceTax() {
        return invoiceTax;
    }

    public void setInvoiceTax(double invoiceTax) {
        this.invoiceTax = invoiceTax;
    }
}
