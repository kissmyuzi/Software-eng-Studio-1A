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
        temp.add(new Event("1234", "1234", "1234", "A Crash Course On Year 8 Mathematics", "Redfern, 261-265 Chalmers St", "05/07/19", "Lorem ipsum dolor sit amet, an per tacimates electram temporibus, in quis amet theophrastus est, vim omnis audire temporibus ea. Ne quas affert epicurei mei. Quo suscipit recteque ad, eu expetenda splendide honestatis quo, no vis epicurei mnesarchum. Omittam conceptam concludaturque nec id, quod suscipiantur nam ea.\n" +
                "\n" +
                "Quando minimum omittantur est ad. Agam essent aeterno eu eum. Ei sed tation tibique verterem, ut sit primis deleniti definitionem. No ius enim congue elaboraret, et vim idque mollis.\n" +
                "\n" +
                "An quot solet mei. Ut qui affert praesent, id mel dico solum persius. Essent tacimates ea vel, vel ut fugit exerci conceptam. Qualisque delicatissimi ex qui. Apeirian consetetur eos in, quaeque vocibus forensibus cu per, has in convenire contentiones.\n" +
                "\n" +
                "Delenit offendit ea eum, mel vero mundi an. Tibique corpora vix id. Eos cu tamquam dolorum, propriae molestiae cotidieque sit id, quaerendum contentiones an quo. Sed vidit mazim an, te vis idque quidam, ne vim scribentur necessitatibus.", "11:30"));
        temp.add(new Event("123", "1234", "1234", "The Crucible: A Technical Analysis", "Surry Hills, 56-60 Albion St", "25/08/19", "Lorem ipsum dolor sit amet, an per tacimates electram temporibus, in quis amet theophrastus est, vim omnis audire temporibus ea. Ne quas affert epicurei mei. Quo suscipit recteque ad, eu expetenda splendide honestatis quo, no vis epicurei mnesarchum. Omittam conceptam concludaturque nec id, quod suscipiantur nam ea.\n" +
                "\n" +
                "Quando minimum omittantur est ad. Agam essent aeterno eu eum. Ei sed tation tibique verterem, ut sit primis deleniti definitionem. No ius enim congue elaboraret, et vim idque mollis.\n" +
                "\n" +
                "An quot solet mei. Ut qui affert praesent, id mel dico solum persius. Essent tacimates ea vel, vel ut fugit exerci conceptam. Qualisque delicatissimi ex qui. Apeirian consetetur eos in, quaeque vocibus forensibus cu per, has in convenire contentiones.\n" +
                "\n" +
                "Delenit offendit ea eum, mel vero mundi an. Tibique corpora vix id. Eos cu tamquam dolorum, propriae molestiae cotidieque sit id, quaerendum contentiones an quo. Sed vidit mazim an, te vis idque quidam, ne vim scribentur necessitatibus.", "14:00"));

        for (Event item: events) {
            temp.add(item);
        }
        return temp;
    }

    public static void addEvent(String name, String date, String location, String description, String time) {
        events.add(new Event("1234", "1234", "blank", name, location, date, description, time));
    }
}
