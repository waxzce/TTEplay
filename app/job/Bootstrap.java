/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package job;

/**
 *
 * @author waxzce
 */
import models.person.Person;
import models.person.GlobalStaff;
import models.person.Staff;
import models.person.Student;
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
            /// nantes campus
            Campus c = new Campus();
            c.name = "Nantes";
            c.save();
            // promo M1
            Promo po = new Promo();
            po.campus = c;
            po.name = "M1";
            po.save();
            /// user waxzce
            Student p = new Student();
            p.dateOfBirth = new Date(88, 4, 5);
            p.firstName = "Quentin";
            p.lastName = "ADAM";
            p.login = "waxzce";
            p.password = "azerty";
            p.mail = "waxzce@gmail.com";
            p.promo = po;
            p.save();
            /// user farof
            Student p2 = new Student();
            p2.dateOfBirth = new Date(70, 0, 1);
            p2.firstName = "Mathieu";
            p2.lastName = "MERDY";
            p2.login = "farof";
            p2.password = "azerty";
            p2.mail = "gfarof@gmail.com";
            p2.promo = po;
            p2.save();
            /// user pherve
            Staff s = new Staff();
            s.dateOfBirth = new Date(70, 0, 1);
            s.firstName = "Philippe";
            s.lastName = "HERVE";
            s.login = "pherve";
            s.password = "azerty";
            s.mail = "pherve@gmail.com";
            s.campus = c;
            s.save();
            /// user gpougne
            GlobalStaff gs = new GlobalStaff();
            gs.dateOfBirth = new Date(70, 0, 1);
            gs.firstName = "Gaetan";
            gs.lastName = "POUGNE";
            gs.login = "gpougne";
            gs.password = "azerty";
            gs.mail = "gpougne@gmail.com";
            gs.save();
        }
    }
}
