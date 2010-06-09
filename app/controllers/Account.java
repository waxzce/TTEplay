package controllers;

import java.util.List;
import models.event.*;
import models.person.Person;
import play.mvc.*;
import com.google.gson.*;

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
        
/*        GsonBuilder gsonB = new GsonBuilder();
        gsonB.registerTypeAdapter(Event.class, new EventSerializer());
        
        Gson gson = gsonB.setPrettyPrinting().create();
        String jsonCalendar = gson.toJson(calendar);*/
        
        render(calendar, user);
    }
}
