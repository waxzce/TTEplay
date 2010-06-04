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
        List<Event> calendar = Person.get(Security.connected()).getCalendar();
        render(calendar);
    }
}
