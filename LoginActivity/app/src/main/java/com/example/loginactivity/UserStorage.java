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

        temp.add(new Event("1234", "1234", "1234", "A Crash Course On Year 8 Mathematics", "Redfern, 261-265 Chalmers St", "05/07/19", "Lorem ipsum dolor sit amet, an per tacimates electram temporibus, in quis amet theophrastus est, vim omnis audire temporibus ea. Ne quas affert epicurei mei. Quo suscipit recteque ad, eu expetenda splendide honestatis quo, no vis epicurei mnesarchum. Omittam conceptam concludaturque nec id, quod suscipiantur nam ea.\n" +
                "\n" +
                "Quando minimum omittantur est ad. Agam essent aeterno eu eum. Ei sed tation tibique verterem, ut sit primis deleniti definitionem. No ius enim congue elaboraret, et vim idque mollis.\n" +
                "\n" +
                "An quot solet mei. Ut qui affert praesent, id mel dico solum persius. Essent tacimates ea vel, vel ut fugit exerci conceptam. Qualisque delicatissimi ex qui. Apeirian consetetur eos in, quaeque vocibus forensibus cu per, has in convenire contentiones.\n" +
                "\n" +
                "Delenit offendit ea eum, mel vero mundi an. Tibique corpora vix id. Eos cu tamquam dolorum, propriae molestiae cotidieque sit id, quaerendum contentiones an quo. Sed vidit mazim an, te vis idque quidam, ne vim scribentur necessitatibus.", "11:30"));

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
        return false;
    }

}
