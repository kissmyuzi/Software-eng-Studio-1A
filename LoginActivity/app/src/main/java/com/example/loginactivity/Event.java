package com.example.loginactivity;

public class Event {
    private String eventId;
    private String userId;
    private String eventIcon; //change data type when possible
    private String eventName;
    private String description;
    private String location;
    private String date;

    public Event(String eventId, String userId, String eventIcon, String eventName, String location, String date, String description) {
        this.eventId = eventId;
        this.userId = userId;
        this.eventIcon = eventIcon;
        this.eventName = eventName;
        this.location = location;
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getEventId() {
        return eventId;
    }

    public String getUserId() {
        return userId;
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
