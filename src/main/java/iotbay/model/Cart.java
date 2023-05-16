package iotbay.model;

import java.io.Serializable;

public class Cart implements Serializable {
    private int cartID;
    private int userAccountID;
    private int anonID;
    public Cart() {
    }

    public Cart(int cartID, int userID, String userType) {
        this.cartID = cartID;
        if(userType.equals("registered")) {
            this.userAccountID = userID;
        } else {
            this.anonID = userID;
        }
    }


    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public int getAnonID() {
        return anonID;
    }

    public void setAnonID(int anonID) {
        this.anonID = anonID;
    }
}
