/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package job;

/**
 *
 * @author waxzce
 */
import java.util.Date;
import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the database is empty
        if (Person.count() == 0) {
//            Person p = new Person();
//            p.dateOfBirth = new Date(1988, 5, 5);
//            p.firstName = "Quentin";
//            p.lastName = "ADAM";
//            p.login = "waxzce";
//            p.password = "azerty";
//            p.mail = "waxzce@gmail.com";
//            p.save();
            Fixtures.load("initdata.yml");
        }
    }
}
