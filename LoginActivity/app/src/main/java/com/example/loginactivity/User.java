package com.example.loginactivity;

import android.content.Context;
import android.content.SharedPreferences;

//import com.google.firebase.events.Event;

import java.util.ArrayList;
import java.util.LinkedList;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String userType;
    private String description;
    private String charityOrg;
    private String rating;
    private LinkedList<Note> uploadHistory;
    private ArrayList<Event> eventHistory;


    private LinkedList<Event> eventAttending;


    public User (String userId, String firstName, String lastName, String emailAddress, String password, String userType, String charityOrg) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.description = "This user has not created a description for themselves yet.";
        this.password = password;
        this.userType = userType;
        this.charityOrg = charityOrg;
        this.rating = "";
        uploadHistory = new LinkedList<Note>();
        eventHistory = new ArrayList<Event>();
        eventAttending = new LinkedList<Event>();
        //eventAttending.add(new Event("1234", "1234", "1234", "Event 1", "Sydney", "19/04/20", "hello"));
        //eventAttending.add(new Event("123", "1234", "1234", "Event 2", "Darwin", "19/04/20", "hello"));
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

    public ArrayList<Event> getEventHistory() { return eventHistory; }

    public LinkedList<Event> getEventAttending() { return eventAttending; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setEvent(Event event) {
        eventHistory.add(event);
    }
}
