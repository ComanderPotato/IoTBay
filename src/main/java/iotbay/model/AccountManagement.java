package iotbay.model;

import java.io.Serializable;

public class AccountManagement implements Serializable {
    private int userAccountID;

    public AccountManagement() {

    }

    public AccountManagement(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }
}
