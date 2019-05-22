package com.example.loginactivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EventStorage { //this is meant to be as static as possible
    public static ArrayList<Event> events = new ArrayList<>();

    private EventStorage() {
        }

    public static ArrayList<Event> getEvents() {
        ArrayList<Event> temp = new ArrayList<>();
        temp.add(new Event("1234", "1234", "1234", "A Crash Course On Year 8 Mathematics", "Redfern, 261-265 Chalmers St", "05/07/19", "As we observe students we know they are natural problem-solvers and creative thinkers. Our goal as teachers is to recognise these learning opportunities and extend and enable learning. However, when we consider students's learning in STEM (Science, Technology, Engineering and Mathematics) sometimes this can be challenging.\n" +
                "\n" +
                "Exploring Science, Technology, Engineering and Mathematics (STEM) will  contribute 6 hours of NESA registered PD addressing 2.6.2 from the Australian Professional Standards for Teachers towards maintaining Proficient Teacher Accreditation in NSW.\n", "11:30"));
        temp.add(new Event("123", "1234", "1234", "The Crucible: A Technical Analysis", "Surry Hills, 56-60 Albion St", "25/08/19", "Tutoring is an age-old practice. The dictionary definition describes a tutor as a person who gives additional, special, or basic instruction. Other definitions state that a tutor is one who guards, protects, watches over, or has the care of another person. It sounds like a heavy responsibility. It is, and if done properly, it can be one of the most generous and rewarding things two or more people can do. Ross MacDonald, in his guidebook The Master Tutor, refers to tutoring as “an act which facilitates or provides a structure for another’s learning.””\n" +
                "\n" +
                "Knowledge of the academic subject is an essential ingredient for a tutor, however not the most important. Annette Gourgey of Upsala College writes “the most profound education that students can receive in tutoring is not about a specific subject but about understanding how to learn, and about their personal role in that process.\n", "14:00"));

        for (Event item: events) {
            temp.add(item);
        }
        return temp;
    }

    public static void addEvent(String name, String date, String location, String description, String time) {
        events.add(new Event("1234", "1234", "blank", name, location, date, description, time));
    }
}
