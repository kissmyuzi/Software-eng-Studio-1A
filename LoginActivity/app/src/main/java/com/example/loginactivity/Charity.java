package com.example.loginactivity;



public class Charity {
    private String charityId;
    private String charityIcon;
    private String charityName;


    public Charity(String charityId, String charityIcon, String charityName) {
        this.charityId = charityId;
        this.charityIcon = charityIcon;
        this.charityName = charityName;
    }

    public String getCharityId() { return charityId; }

    public String getCharityIcon() { return charityIcon; }

    public String getCharityName() { return charityName; }
}
