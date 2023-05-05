package iotbay.model;

import java.io.Serializable;

public class DeviceCollection implements Serializable {
    private int deviceCollectionID;
    private int shipmentID;
    private int stockID;

    public DeviceCollection() {
    }

    public DeviceCollection(int deviceCollectionID, int shipmentID, int stockID) {
        this.deviceCollectionID = deviceCollectionID;
        this.shipmentID = shipmentID;
        this.stockID = stockID;
    }

    public int getDeviceCollectionID() {
        return deviceCollectionID;
    }

    public void setDeviceCollectionID(int deviceCollectionID) {
        this.deviceCollectionID = deviceCollectionID;
    }

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }
}
