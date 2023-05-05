package iotbay.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int staffID;
    private String position;
    private String department;
    public Staff() {

    }

    public Staff(String position, String department) {
        this.position = position;
        this.department = department;
    }

    public Staff(int staffID, String position, String department) {
        this.staffID = staffID;
        this.position = position;
        this.department = department;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
