package com.example.csp;

public class AddressInfo {
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public AddressInfo(String street, String city, String state, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public AddressInfo() {
    }

    public String getSampleAddress() {
        String full = this.street + " " + this.city;
        String[] words = full.split("\\s");
        String sampleAddress = "";
        String[] var4 = words;
        int var5 = words.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String w = var4[var6];
            String first = w.substring(0, 1);
            String afterfirst = w.substring(1);
            sampleAddress = sampleAddress + first.toUpperCase() + afterfirst + " ";
        }

        return sampleAddress;
    }

    public String toString() {
        return this.street + ", " + this.city + ", " + this.state + ", " + this.postalCode + ", " + this.country;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void validate() {
    }
}
