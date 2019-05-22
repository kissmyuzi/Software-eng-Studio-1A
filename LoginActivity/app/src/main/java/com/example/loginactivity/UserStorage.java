package com.example.loginactivity;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UserStorage { //idea is to be as static as possible
    public static ArrayList<Event> events = new ArrayList<>();
    public static ArrayList<Event> eventHistory = new ArrayList<>();

    private UserStorage() {}

    public static ArrayList<Event> getEvents() {
        ArrayList<Event> temp = new ArrayList<>();

        temp.add(new Event("1234", "1234", "1234", "A Crash Course On Year 8 Mathematics", "Redfern, 261-265 Chalmers St", "05/07/19", "As a tutor, you need to accept the responsibility for your assignment. Tutees generally come to you with a certain amount of respect for your role. It's important for a tutor to develop a rapport with students who seek assistance. Become familiar with methods for Getting to Know the Student. \n" +
                "\n" +
                "Intelligence alone does not indicate success as a tutor; but what kind of person, what kind of student you are does. It takes a certain kind of person to be a good tutor. Some of the characteristics noticeable in good tutors.\n" +
                "\n" +
                "Tutoring is one of the most beneficial things you can do as a LEARNER. It will teach you more about your subject and about thinking than the typical classroom experience..", "11:30"));

        for (Event item: events) {
            temp.add(item);
        }

        return temp;
    }

    public static void addEvent(String name, String date, String location, String description, String time) {
        if (dateCheck(date)) events.add(new Event("1234", "1234", "blank", name, location, date, description, time));
        else eventHistory.add(new Event("1234", "1234", "blank", name, location, date, description, time));

    }

    public static boolean compareEvent(String name) {
        for (Event item: getEvents()) {
            if (item.getEventName().equals(name)) return true;
        }
        return false;
    }

    public static boolean dateCheck(String eventDate)  {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
        String strDate = dateFormat.format(date);
        try {
            Date current = dateFormat.parse(strDate);
            Date event = dateFormat.parse(eventDate);
            return event.after(current);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
