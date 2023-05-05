package iotbay.model;

import java.io.Serializable;

public class StaffAccount implements Serializable {
    private int staffAccountID;
    private int registrationID;
    private int deviceCollectionID;
    private int stockID;
    private int notificationID;
    private int orderTrackingID;
    private String staffPhone;
    public StaffAccount() {
    }

    public StaffAccount(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public StaffAccount(
            int staffAccountID,
            int registrationID,
            int deviceCollectionID,
            int stockID,
            int notificationID,
            int orderTrackingID,
            String staffPhone
    ) {
        this.staffAccountID = staffAccountID;
        this.registrationID = registrationID;
        this.deviceCollectionID = deviceCollectionID;
        this.stockID = stockID;
        this.notificationID = notificationID;
        this.orderTrackingID = orderTrackingID;
        this.staffPhone = staffPhone;
    }

    public int getStaffAccountID() {
        return staffAccountID;
    }

    public void setStaffAccountID(int staffAccountID) {
        this.staffAccountID = staffAccountID;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public int getDeviceCollectionID() {
        return deviceCollectionID;
    }

    public void setDeviceCollectionID(int deviceCollectionID) {
        this.deviceCollectionID = deviceCollectionID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getOrderTrackingID() {
        return orderTrackingID;
    }

    public void setOrderTrackingID(int orderTrackingID) {
        this.orderTrackingID = orderTrackingID;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }
}
