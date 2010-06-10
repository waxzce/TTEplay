package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import models.event.Event;
import models.event.GlobalEvent;
import models.person.Person;
import models.person.Student;
import org.hibernate.Session;
import org.yaml.snakeyaml.Yaml;
import play.db.jpa.JPA;
import play.mvc.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        redirect("/Account/mycalendar");
    }

    public static void dumpDBYAML() {
        Yaml yaml = new Yaml();
        String syaml = "";

        for (Iterator it = Person.all().fetch().iterator(); it.hasNext();) {
            Person p = (Person) it.next();
            syaml = syaml + " \n " + yaml.dump(p);
        }
        syaml = syaml + " \n # ---- events now ----- \n";
        for (Iterator it = Event.all().fetch().iterator(); it.hasNext();) {
            Event e = (Event) it.next();
            syaml = syaml + " \n " + yaml.dump(e);
        }

        renderText(syaml);
    }

    public static void dumpPersonJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        renderJSON(gson.toJson(Person.all().fetch()));
    }

    public static void dumpEventsJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        renderJSON(gson.toJson(Event.all().fetch()));
    }

    /*public static void dumpEventStudentCalendarJSON(Long id) {
        Student s = Student.findById(id);
        EntityManager em = JPA.em();
        //  List l = em.createQuery("from CampusEvent ce, ExamEvent ee, GlobalEvent ge, LessonEvent le, PersoEvent pe where ce.campus = :campus").setParameter("campus", s.promo.campus).getResultList();
        List l = em.createQuery("from Event e where e.global = true OR e.person = :person OR e.promo = :promo OR e.campus = :campus")
                .setParameter("person", s)
                .setParameter("promo", s.promo)
                .setParameter("campus", s.promo.campus)
                .getResultList();


        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        renderJSON(gson.toJson(l));
    }
     * */
     
}
