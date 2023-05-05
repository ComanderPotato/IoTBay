package iotbay.model;

import java.io.Serializable;

public class Registration implements Serializable {
    private int registerID;
    private String firstName;
    private String lastName;
    private String DOB;
    private String phoneNo;
    private String email;
    private String password;
    private String dateRegistered;

    public Registration() {
    }

    public Registration(
            String firstName,
            String lastName,
            String DOB,
            String phoneNo,
            String email,
            String password,
            String dateRegistered
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.dateRegistered = dateRegistered;
    }

    public Registration(
            int registerID,
            String firstName,
            String lastName,
            String DOB,
            String phoneNo,
            String email,
            String password,
            String dateRegistered
    ) {
        this.registerID = registerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.dateRegistered = dateRegistered;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
