package iotbay.model;

import java.io.Serializable;

public class UserAccount implements Serializable {
    private int userAccountID;
    private int customerID;
    private int paymentID;
    private int orderHistoryID;
    private int orderTrackingID;
    private int addressID;
    private int cartID;
    public UserAccount() {
    }

    public UserAccount(int userAccountID, int customerID) {
        this.userAccountID = userAccountID;
        this.customerID = customerID;
    }
    public UserAccount(
            int userAccountID,
            int customerID,
            int paymentID,
            int orderHistoryID,
            int orderTrackingID,
            int addressID,
            int cartID
    ) {
        this.userAccountID = userAccountID;
        this.customerID = customerID;
        this.paymentID = paymentID;
        this.orderHistoryID = orderHistoryID;
        this.orderTrackingID = orderTrackingID;
        this.addressID = addressID;
        this.cartID = cartID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getOrderHistoryID() {
        return orderHistoryID;
    }

    public void setOrderHistoryID(int orderHistoryID) {
        this.orderHistoryID = orderHistoryID;
    }

    public int getOrderTrackingID() {
        return orderTrackingID;
    }

    public void setOrderTrackingID(int orderTrackingID) {
        this.orderTrackingID = orderTrackingID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getCardID() {
        return cartID;
    }

    public void setCardID(int cardID) {
        this.cartID = cardID;
    }
}
