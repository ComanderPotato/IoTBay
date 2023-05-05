package iotbay.model;

import java.io.Serializable;

public class StockManagement implements Serializable {
    private int stockID;
    private int productID;

    public StockManagement() {
    }

    public StockManagement(int stockID, int productID) {
        this.stockID = stockID;
        this.productID = productID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
