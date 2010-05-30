package controllers;

import java.util.Iterator;
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
        renderText(syaml);
    }
}
