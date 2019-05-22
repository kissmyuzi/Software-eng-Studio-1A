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
        temp.add(new Event("123", "1234", "1234", "The Crucible: A Technical Analysis", "Surry Hills, 56-60 Albion St", "25/08/19", "In the Puritan New England town of Salem, Massachusetts, a group of girls goes dancing in the forest with a black slave named Tituba. While dancing, they are caught by the local minister, Reverend Parris. One of the girls, Parris’s daughter Betty, falls into a coma-like state. A crowd gathers in the Parris home while rumors of witchcraft fill the town. Having sent for Reverend Hale, an expert on witchcraft, Parris questions Abigail Williams, the girls’ ringleader, about the events that took place in the forest. Abigail, who is Parris’s niece and ward, admits to doing nothing beyond “dancing.”\n" +
                "\n" +
                "While Parris tries to calm the crowd that has gathered in his home, Abigail talks to some of the other girls, telling them not to admit to anything. John Proctor, a local farmer, then enters and talks to Abigail alone. Unbeknownst to anyone else in the town, while working in Proctor’s home the previous year she engaged in an affair with him, which led to her being fired by his wife, Elizabeth. Abigail still desires Proctor, but he fends her off and tells her to end her foolishness with the girls.\n" +
                "\n" +
                "Betty wakes up and begins screaming. Much of the crowd rushes upstairs and gathers in her bedroom, arguing over whether she is bewitched. A separate argument between Proctor, Parris, the argumentative Giles Corey, and the wealthy Thomas Putnam soon ensues. This dispute centers on money and land deeds, and it suggests that deep fault lines run through the Salem community. As the men argue, Reverend Hale arrives and examines Betty, while Proctor departs. Hale quizzes Abigail about the girls’ activities in the forest, grows suspicious of her behavior, and demands to speak to Tituba. After Parris and Hale interrogate her for a brief time, Tituba confesses to communing with the devil, and she hysterically accuses various townsfolk of consorting with the devil. Suddenly, Abigail joins her, confessing to having seen the devil conspiring and cavorting with other townspeople. Betty joins them in naming witches, and the crowd is thrown into an uproar.", "14:00"));

        for (Event item: events) {
            temp.add(item);
        }
        return temp;
    }

    public static void addEvent(String name, String date, String location, String description, String time) {
        events.add(new Event("1234", "1234", "blank", name, location, date, description, time));
    }
}
