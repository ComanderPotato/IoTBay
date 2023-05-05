package iotbay.model;

import java.io.Serializable;

public class Cart implements Serializable {
    private int cartID;
    private int orderID;

    public Cart() {
    }

    public Cart(int cartID, int orderID) {
        this.cartID = cartID;
        this.orderID = orderID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
