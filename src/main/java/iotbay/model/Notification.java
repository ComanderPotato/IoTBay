package iotbay.model;

import java.io.Serializable;

public class Notification implements Serializable {
    private int notificationID;
    private int shipmentID;
    private String notifDescription;

    public Notification() {
    }

    public Notification(String notifDescription) {
        this.notifDescription = notifDescription;
    }

    public Notification(int notificationID, int shipmentID, String notifDescription) {
        this.notificationID = notificationID;
        this.shipmentID = shipmentID;
        this.notifDescription = notifDescription;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public String getNotifDescription() {
        return notifDescription;
    }

    public void setNotifDescription(String notifDescription) {
        this.notifDescription = notifDescription;
    }
}
