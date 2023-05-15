package iotbay.model;

import java.io.Serializable;

public class CartItem implements Serializable {

    private int CartItemID;
    private int cartID;
    private int productID;
    private int cartItemQuantity;
    public CartItem() {

    }

    public CartItem(int cartItemID, int cartID, int productID, int cartItemQuantity) {
        CartItemID = cartItemID;
        this.cartID = cartID;
        this.productID = productID;
        this.cartItemQuantity = cartItemQuantity;
    }

    public int getCartItemID() {
        return CartItemID;
    }

    public void setCartItemID(int cartItemID) {
        CartItemID = cartItemID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }


}
