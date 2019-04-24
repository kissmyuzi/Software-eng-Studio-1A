package com.example.loginactivity;

import java.util.List;

public class Tutor extends User {
    private boolean certified;
    private List<Event> eventHosting;



    public Tutor(boolean certified) {
        super();
        this.certified = certified;
        eventHosting = new LinkedList<Event>();
    }

    public boolean getCertified() { return certified; }

    public LinkedList<Event> getEventHosting() { return eventHosting; }
}
