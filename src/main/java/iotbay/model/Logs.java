package iotbay.model;

import java.io.Serializable;

public class Logs implements Serializable {
    private int logID;
    private int userAccountID;
    private String activity;
    private String logTime;
    public Logs() {

    }

    public Logs(String activity, String logTime) {
        this.activity = activity;
        this.logTime = logTime;
    }

    public Logs(int logID, int userAccountID, String activity, String logTime) {
        this.logID = logID;
        this.userAccountID = userAccountID;
        this.activity = activity;
        this.logTime = logTime;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }
}
