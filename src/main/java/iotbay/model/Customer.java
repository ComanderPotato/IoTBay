/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iotbay.model;

import java.io.Serializable;

/**
 *
 * @author tomgolding
 */
public class Customer implements Serializable {
    private int customerID;
    private String customerEmail;
    private String customerPassword;
    private String customerFirstName;
    private String customerLastName;
    private String customerDOB;
    private String customerPhone;
    
    public Customer() {
        
    }
    public Customer(
            String customerEmail,
            String customerPassword,
            String customerFirstName,
            String customerLastName,
            String customerDOB,
            String customerPhone
    ) {
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerDOB = customerDOB;
        this.customerPhone = customerPhone;
    }
    public Customer(
            int customerID,
            String customerEmail,
            String customerPassword,
            String customerFirstName,
            String customerLastName,
            String customerDOB,
            String customerPhone
    ) {
        this.customerID = customerID;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerDOB = customerDOB;
        this.customerPhone = customerPhone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerDOB() {
        return customerDOB;
    }

    public void setCustomerDOB(String customerDOB) {
        this.customerDOB = customerDOB;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
}

