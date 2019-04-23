package com.example.loginactivity;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String userType;
    private String charityOrg;


    public User (String userId, String firstName, String lastName, String emailAddress, String password, String userType, String charityOrg) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.userType = userType;
        this.charityOrg = charityOrg;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getCharityOrg() {
        return charityOrg;
    }
}
