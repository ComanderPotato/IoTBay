package iotbay.model;

import java.io.Serializable;

public class Shipment implements Serializable {
    private int shipmentID;
    private int addressID;
    private int orderID;
    private String shipmentMethod;
    private String shipmentDate;
    private double shipmentCost;

    public Shipment() {
    }

    public Shipment(
            String shipmentMethod,
            String shipmentDate,
            double shipmentCost
    ) {
        this.shipmentMethod = shipmentMethod;
        this.shipmentDate = shipmentDate;
        this.shipmentCost = shipmentCost;
    }

    public Shipment(
            int shipmentID,
            int addressID,
            int orderID,
            String shipmentMethod,
            String shipmentDate,
            double shipmentCost
    ) {
        this.shipmentID = shipmentID;
        this.addressID = addressID;
        this.orderID = orderID;
        this.shipmentMethod = shipmentMethod;
        this.shipmentDate = shipmentDate;
        this.shipmentCost = shipmentCost;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public double getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(double shipmentCost) {
        this.shipmentCost = shipmentCost;
    }
}
