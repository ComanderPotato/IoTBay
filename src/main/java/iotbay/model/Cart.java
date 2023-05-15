package iotbay.model;

import java.io.Serializable;

public class Cart implements Serializable {
    private int cartID;
    private int userAccountID;

    public Cart() {
    }

    public Cart(int cartID, int orderID) {
        this.cartID = cartID;
        this.userAccountID = orderID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getOrderID() {
        return userAccountID;
    }

    public void setOrderID(int orderID) {
        this.userAccountID = orderID;
    }
}
