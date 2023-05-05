package iotbay.model;

import java.io.Serializable;

public class Payment implements Serializable {
    private int paymentID;
    private int userAccountID;
    private String paymentType;
    private String cardName;
    private int cardNumber;
    private String cardExpiry;
    private int cardCVV;

    public Payment() {
    }

    public Payment(
            String paymentType,
            String cardName,
            int cardNumber,
            String cardExpiry,
            int cardCVV
    ) {
        this.paymentType = paymentType;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
    }

    public Payment(
            int paymentID,
            int userAccountID,
            String paymentType,
            String cardName,
            int cardNumber,
            String cardExpiry,
            int cardCVV
    ) {
        this.paymentID = paymentID;
        this.userAccountID = userAccountID;
        this.paymentType = paymentType;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCVV = cardCVV;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public int getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(int cardCVV) {
        this.cardCVV = cardCVV;
    }
}
