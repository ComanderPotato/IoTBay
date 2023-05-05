package iotbay.model;

import java.io.Serializable;

public class OrderTracking implements Serializable {
    private int orderTrackingID;
    private int shipmentID;
    private String trackStatus;

    public OrderTracking() {
    }

    public OrderTracking(String trackStatus) {
        this.trackStatus = trackStatus;
    }

    public OrderTracking(int orderTrackingID, int shipmentID, String trackStatus) {
        this.orderTrackingID = orderTrackingID;
        this.shipmentID = shipmentID;
        this.trackStatus = trackStatus;
    }

    public int getOrderTrackingID() {
        return orderTrackingID;
    }

    public void setOrderTrackingID(int orderTrackingID) {
        this.orderTrackingID = orderTrackingID;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }
}
