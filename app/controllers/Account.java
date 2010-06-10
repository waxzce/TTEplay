package controllers;

import java.util.List;
import models.event.*;
import models.person.Person;
import play.mvc.*;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.Iterator;
import util.FullCalendarEvent;

@With(Secure.class)
public class Account extends Controller {

    public static void index() {
        String user = Security.connected();
        render(user);
    }

    public static void me() {
        Person user = Security.get();
        String profiles = "";
        if (Security.check("student")) {
            profiles = "student";
        }
        if (Security.check("staff")) {
            profiles = "staff";
        }
        if (Security.check("globalstaff")) {
            profiles = "globalstaff";
        }
        if (Security.check("teacher")) {
            profiles = "teacher";
        }
        render(user, profiles);
    }

    public static void mycalendar() {
        Person user = Person.get(Security.connected());
        List<Event> calendar = user.getCalendar();
        List<FullCalendarEvent> lfes = new ArrayList<FullCalendarEvent>();
        for (Iterator<Event> it = calendar.iterator(); it.hasNext();) {
            Event event = it.next();
            FullCalendarEvent fce = new FullCalendarEvent();
            fce.allDay = false;
            fce.className = event.getClass().getName();
            fce.editable = false;
            fce.end = event.end;
            fce.start = event.start;
            fce.id = event.id;
            fce.title = event.name;
            fce.url = "";
            lfes.add(fce);
        }

        Gson gson = new Gson();

        String jsoncal = gson.toJson(lfes);


        /*        GsonBuilder gsonB = new GsonBuilder();
        gsonB.registerTypeAdapter(Event.class, new EventSerializer());
        
        Gson gson = gsonB.setPrettyPrinting().create();
        String jsonCalendar = gson.toJson(calendar);*/

        render(calendar, user, jsoncal);
    }

    public static void jsonmycal(){
        Person user = Person.get(Security.connected());
        List<Event> calendar = user.getCalendar();
        List<FullCalendarEvent> lfes = new ArrayList<FullCalendarEvent>();
        for (Iterator<Event> it = calendar.iterator(); it.hasNext();) {
            Event event = it.next();
            FullCalendarEvent fce = new FullCalendarEvent();
            fce.allDay = false;
            fce.className = event.getClass().getName();
            fce.editable = false;
            fce.end = event.end;
            fce.start = event.start;
            fce.id = event.id;
            fce.title = event.name;
            fce.url = "";
            lfes.add(fce);
        }

        Gson gson = new Gson();

        String jsoncal = gson.toJson(lfes);
        renderJSON(jsoncal);
    }
}
