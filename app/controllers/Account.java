package controllers;

import java.util.List;
import models.event.Event;
import models.person.Person;
import play.mvc.*;

@With(Secure.class)
public class Account extends Controller {

    public static void index() {
        String user = Security.connected();
        render(user);
    }

    public static void mycalendar() {
        Person user = Person.get(Security.connected());
        List<Event> calendar = user.getCalendar();
        render(calendar, user);
    }
}
