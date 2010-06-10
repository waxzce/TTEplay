package controllers;

import java.util.List;
import models.event.*;
import models.person.Person;
import play.mvc.*;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.joda.time.DateTime;
import util.FullCalendarEvent;

@With(Secure.class)
public class Event extends Controller {

    public static void json(Long id) {

        models.event.Event e = models.event.Event.findById(id);

        Gson gson = new Gson();

        String json = gson.toJson(e);
        renderJSON(json);
    }
}
