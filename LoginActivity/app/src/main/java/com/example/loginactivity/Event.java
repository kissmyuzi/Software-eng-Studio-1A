package com.example.loginactivity;


public class Event {
    private String eventId;
    private String userIcon;
    private String eventIcon; //change data type when possible
    private String eventName;
    private String location;
    private String date;


    public Event(String eventId, String userIcon, String eventIcon, String eventName, String location, String date) {
        this.eventId = eventId;
        this.userIcon = userIcon;
        this.eventIcon = eventIcon;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
    }

    public String getEventId() {
        return eventId;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public String getEventIcon() {
        return eventIcon;
    }

    public String getEventName() {
        return eventName;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
