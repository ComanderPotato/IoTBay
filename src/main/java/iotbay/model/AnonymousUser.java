package iotbay.model;

import java.io.Serializable;

public class AnonymousUser implements Serializable {
    private int anonID;
    private int cartID;

    public AnonymousUser() {
    }

    public AnonymousUser(int anonID, int cartID) {
        this.anonID = anonID;
        this.cartID = cartID;
    }

    public int getAnonID() {
        return anonID;
    }

    public void setAnonID(int anonID) {
        this.anonID = anonID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }
}
