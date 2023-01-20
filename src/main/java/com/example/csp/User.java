package com.example.csp;

public abstract class User {
    private String username;
    private String password;
    private String emailAddress;
    private int phoneNumber;
    private AddressInfo addressInfo;

    public User(String var1, String var2, String var3, int var4, AddressInfo var5) {
        this.username = var1;
        this.password = var2;
        this.emailAddress = var3;
        this.phoneNumber = var4;
        this.addressInfo = var5;
    }

    public User(String username, String emailAddress, String phoneNumber, String password) {
    }

    public User(String var1, String var2) {
        this.username = var1;
        this.password = var2;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public AddressInfo getAddressInfo() {
        return this.addressInfo;
    }
}
