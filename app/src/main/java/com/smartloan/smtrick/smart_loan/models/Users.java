package com.smartloan.smtrick.smart_loan.models;

public class Users {

    private String name;
    private String mobilenumber;

    public Users() {
    }

    public Users(String name, String mobilenumber) {
        this.name = name;
        this.mobilenumber = mobilenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }
}
