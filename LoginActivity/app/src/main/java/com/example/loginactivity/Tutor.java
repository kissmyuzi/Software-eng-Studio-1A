package com.example.loginactivity;

import java.util.LinkedList;

public class Tutor extends User {
    private boolean certified;
    private LinkedList<Event> eventHosting;

    public Tutor(String userId, String firstName, String lastName, String emailAddress, String password, String userType, String charityOrg, boolean certified) {
        super(userId, firstName, lastName, emailAddress, password, userType, charityOrg);
        this.certified = certified;
        eventHosting = new LinkedList<>();
    }

    public boolean getCertified() { return certified; }

    public LinkedList<Event> getEventHosting() { return eventHosting; }
}
