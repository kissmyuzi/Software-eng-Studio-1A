package com.example.loginactivity;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.LinkedList;

public abstract class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String userType;
    private String charityOrg;
    private String rating;
    private LinkedList<Note> uploadHistory;
    private LinkedList<Event> eventHistory;
    private LinkedList<Event> eventAttending;


    public User (String userId, String firstName, String lastName, String emailAddress, String password, String userType, String charityOrg) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.userType = userType;
        this.charityOrg = charityOrg;
        uploadHistory = new LinkedList<Note>();
        eventHistory = new LinkedList<Event>();
        eventAttending = new LinkedList<Event>();
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

    public String getRating() { return rating; }

    public LinkedList<Note> getUploadHistory() { return uploadHistory; }

    public LinkedList<Event> getEventHistory() { return eventHistory; }

    public LinkedList<Event> getEventAttending() { return eventAttending; }
}