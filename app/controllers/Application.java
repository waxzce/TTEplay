package controllers;

import java.util.Iterator;
import models.event.Event;
import models.person.Person;
import org.yaml.snakeyaml.Yaml;
import play.mvc.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        render();
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
}
