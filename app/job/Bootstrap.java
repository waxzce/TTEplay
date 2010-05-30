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
            /// user waxzce
            Student p2 = new Student();
            p2.dateOfBirth = new Date(70, 0, 1);
            p2.firstName = "Mathieu";
            p2.lastName = "MERDY";
            p2.login = "farof";
            p2.password = "azerty";
            p2.mail = "gfarof@gmail.com";
            p2.promo = po;
            p2.save();
        }
    }
}
