/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package job;

/**
 *
 * @author waxzce
 */
import java.util.ArrayList;
import java.util.Collections;
import models.person.Person;
import models.person.GlobalStaff;
import models.person.Staff;
import models.person.Student;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import play.*;
import play.jobs.*;
import play.test.*;

import models.*;
import models.event.CampusEvent;
import models.event.eval.ExamEvalEvent;
import models.event.GlobalEvent;
import models.event.LessonEvent;
import models.event.PersoEvent;
import models.event.eval.OralEvalEvent;
import models.event.eval.PracticalEvalEvent;
import models.i.LessonMode;
import models.person.Teacher;
import org.joda.time.DateTime;
import org.joda.time.Interval;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the database is empty
        Fixtures.deleteAllEntities();
        // if (Person.count() == 0) {
        /// nantes campus
        Campus c = new Campus();
        c.name = "Nantes";
        c.save();
        Campus c2 = new Campus();
        c2.name = "Tours";
        c2.save();
        Campus paris = new Campus();
        paris.name = "Paris";
        paris.save();
        Campus toulouse = new Campus();
        toulouse.name = "Toulouse";
        toulouse.save();
        Campus bordeau = new Campus();
        bordeau.name = "Bordeau";
        bordeau.save();
        // promo M1
        Promo b1 = new Promo();
        b1.name = "B1";
        b1.save();
        Promo b2 = new Promo();
        b2.name = "B2";
        b2.save();
        Promo pro = new Promo();
        pro.name = "M1";
        pro.save();
        Promo m2 = new Promo();
        m2.name = "M2";
        m2.save();
        Promo b3 = new Promo();
        b3.name = "B3";
        b3.save();

        List<Promo> lp = Promo.findAll();
        List<Campus> lc = Campus.findAll();
        for (Iterator<Promo> it = lp.iterator(); it.hasNext();) {
            Promo promo = it.next();
            for (Iterator<Campus> it1 = lc.iterator(); it1.hasNext();) {
                Campus campus = it1.next();
                Klass klass = new Klass();
                klass.name = promo.name + "A";
                klass.promo = promo;
                klass.campus = campus;
                klass.save();
                if (Math.random() < 0.2) {
                    Klass klass2 = new Klass();
                    klass2.name = promo.name + "B";
                    klass2.promo = promo;
                    klass2.campus = campus;
                    klass2.save();
                }
            }
        }
        // promo M1


        Lesson lll = new Lesson();
        lll.name = "Java";

        lll.save();
        Lesson linuxlesson = new Lesson();
        linuxlesson.name = "Linux";

        linuxlesson.save();
        Lesson microsoftlesson = new Lesson();
        microsoftlesson.name = "Microsoft";

        microsoftlesson.save();
        Lesson OracleLesson = new Lesson();
        OracleLesson.name = "Oracle";

        OracleLesson.save();
        Lesson itlawlesson = new Lesson();
        itlawlesson.name = "IT Law";

        itlawlesson.save();

        List<String> lprenoms = new ArrayList<String>();
        List<String> lnoms = new ArrayList<String>();
        List<Klass> lklass = Klass.findAll();

        Collections.addAll(lprenoms,
                "Alexandre", "Ines", "Mathis", "Marie", "Nathan", "Lucas", "Lea", "Theo", "Manon", "Hugo", "Emma", "Thomas", "Chloe", "Enzo", "Camille", "Maxime", "Oceane");
        Collections.addAll(lnoms,
                "Anastasie", "Dubourg", "Dumesnil", "Félicité", "Grenet", "Isidore", "Nastasie", "Roger", "Victoire", "Atala", "Desnoyers", "Bovary", "Yseult", "Maria", "Rouault", "Léocadie", "Charles");
        int y = 0;
        for (Iterator<String> it = lnoms.iterator(); it.hasNext();) {
            String string = it.next();
            lnoms.set(y, string.toUpperCase());
            y++;
        }
        Random randomGenerator = new Random();
        for (int i = 0; i < 70; i++) {
            Student p = new Student();
            p.firstName = lprenoms.get(randomGenerator.nextInt(lprenoms.size()));
            p.lastName = lnoms.get(randomGenerator.nextInt(lnoms.size()));
            p.login = (p.firstName.substring(0, 1) + p.lastName).toLowerCase();
            p.password = "azerty";
            p.mail = p.login + "@globalcampus.com";
            p.klass = lklass.get(randomGenerator.nextInt(lklass.size()));
            p.dateOfBirth = new Date(95 - randomGenerator.nextInt(11), randomGenerator.nextInt(11), randomGenerator.nextInt(11));
            p.save();
        }

        /// user waxzce
        Student pppp = new Student();
        pppp.dateOfBirth = new Date(95 - randomGenerator.nextInt(11), randomGenerator.nextInt(11), randomGenerator.nextInt(11));
        pppp.firstName = "Quentin";
        pppp.lastName = "ADAM";
        pppp.login = "waxzce";
        pppp.password = "azerty";
        pppp.mail = "waxzce@gmail.com";
        pppp.klass = lklass.get(randomGenerator.nextInt(lklass.size()));

        pppp.save();

        for (Iterator<Campus> it = lc.iterator(); it.hasNext();) {
            Campus campus = it.next();
            Staff p = new Staff();
            p.dateOfBirth = new Date(75 - randomGenerator.nextInt(11), randomGenerator.nextInt(11), randomGenerator.nextInt(11));
            p.firstName = lprenoms.get(randomGenerator.nextInt(lprenoms.size()));
            p.lastName = lnoms.get(randomGenerator.nextInt(lnoms.size()));
            p.login = (p.firstName.substring(0, 1) + p.lastName).toLowerCase();
            p.password = "azerty";
            p.mail = p.login + "@globalcampus.com";
            p.campus = campus;
            p.save();
        }

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
        Staff s2 = new Staff();
        s2.dateOfBirth = new Date(70, 0, 1);
        s2.firstName = "Josef";
        s2.lastName = "ROUSSEAU";
        s2.login = "jrousseau";
        s2.password = "azerty";
        s2.mail = "jrousseau@gmail.com";
        s2.campus = c2;
        List<Lesson> listlesson = Lesson.findAll();
        for (int i = 0; i < 20; i++) {
            Teacher p = new Teacher();
            p.firstName = lprenoms.get(randomGenerator.nextInt(lprenoms.size()));
            p.lastName = lnoms.get(randomGenerator.nextInt(lnoms.size()));
            p.login = (p.firstName.substring(0, 1) + p.lastName).toLowerCase();
            p.password = "azerty";
            p.lesson = listlesson.get(randomGenerator.nextInt(listlesson.size()));
            p.mail = p.login + "@globalcampus.com";
            p.dateOfBirth = new Date(90 - randomGenerator.nextInt(11), randomGenerator.nextInt(11), randomGenerator.nextInt(11));
            p.save();
        }

        for (Iterator<Lesson> it = listlesson.iterator(); it.hasNext();) {
            Lesson lesson = it.next();
            Teacher p = new Teacher();
            p.firstName = lprenoms.get(randomGenerator.nextInt(lprenoms.size()));
            p.lastName = lnoms.get(randomGenerator.nextInt(lnoms.size()));
            p.login = (p.firstName.substring(0, 1) + p.lastName).toLowerCase();
            p.lesson = lesson;
            p.password = "azerty";
            p.mail = p.login + "@globalcampus.com";
            p.dateOfBirth = new Date(90 - randomGenerator.nextInt(11), randomGenerator.nextInt(11), randomGenerator.nextInt(11));
            p.save();
        }
        s2.save();
        Teacher tea = new Teacher();
        tea.dateOfBirth = new Date(70, 0, 1);
        tea.firstName = "Kevin";
        tea.lastName = "DECHERF";
        tea.login = "kdecherf";
        tea.mail = "kdecherf@gmail.com";
        tea.password = "azerty";

        tea.save();
        /// user gpougne

        for (int i = 0; i < 5; i++) {
            GlobalStaff p = new GlobalStaff();
            p.firstName = lprenoms.get(randomGenerator.nextInt(lprenoms.size()));
            p.lastName = lnoms.get(randomGenerator.nextInt(lnoms.size()));
            p.login = (p.firstName.substring(0, 1) + p.lastName).toLowerCase();
            p.password = "azerty";
            p.mail = p.login + "@globalcampus.com";
            p.dateOfBirth = new Date(80 - randomGenerator.nextInt(11), randomGenerator.nextInt(11), randomGenerator.nextInt(11));
            p.save();
        }
        GlobalStaff gs = new GlobalStaff();
        gs.dateOfBirth = new Date(70, 0, 1);
        gs.firstName = "Gaetan";
        gs.lastName = "POUGNE";
        gs.login = "gpougne";
        gs.password = "azerty";
        gs.mail = "gpougne@gmail.com";

        gs.save();

        int thisyear = (new DateTime()).getYear();
        int thismonth = (new DateTime()).getMonthOfYear();
        int thisday = (new DateTime()).getDayOfMonth();
        //global event;
        for (int i = 0; i < 5; i++) {
            GlobalEvent ge = new GlobalEvent();
            ge.name = "CEO talk";
            ge.description = "a talk";
            //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
            DateTime dt = new DateTime(thisyear, thismonth + randomGenerator.nextInt(2), thisday + randomGenerator.nextInt(20), 9 + randomGenerator.nextInt(5), 0, 0, 0);
            ge.start = dt.getMillis();
            dt.plusHours(randomGenerator.nextInt(2));
            ge.end = dt.getMillis();

            ge.save();
        }

        //campus event;

        for (int i = 0; i < 20; i++) {
            CampusEvent ge = new CampusEvent();
            ge.name = "JPO";
            ge.description = "jpo";
            //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
            DateTime dt = new DateTime(thisyear, thismonth + randomGenerator.nextInt(2), thisday + randomGenerator.nextInt(20), 9 + randomGenerator.nextInt(5), 0, 0, 0);
            ge.start = dt.getMillis();
            dt.plusHours(randomGenerator.nextInt(2));
            ge.end = dt.getMillis();
            ge.campus = lc.get(randomGenerator.nextInt(lc.size()));
            ge.save();
        }



        for (int i = 0; i < 60; i++) {
            ExamEvalEvent ge = new ExamEvalEvent();
            ge.lesson = listlesson.get(randomGenerator.nextInt(listlesson.size()));
            ge.promo = lp.get(randomGenerator.nextInt(lp.size()));
            //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
            DateTime dt = new DateTime(thisyear, thismonth + randomGenerator.nextInt(2), thisday + randomGenerator.nextInt(20), 9 + randomGenerator.nextInt(5), 0, 0, 0);
            ge.start = dt.getMillis();
            dt.plusHours(randomGenerator.nextInt(2));
            ge.end = dt.getMillis();

            ge.name = "SGES : " + ge.lesson.name;
            ge.description = "sges for the " + ge.lesson.name;

            ge.save();
        }

        List<Teacher> listTeacher = Teacher.findAll();
        //lesson event;

        for (int i = 0; i < 450; i++) {
            LessonEvent ge = new LessonEvent();
            ge.lesson = listlesson.get(randomGenerator.nextInt(listlesson.size()));
            ge.teacher = listTeacher.get(randomGenerator.nextInt(listTeacher.size()));
           
            ge.klass = lklass.get(randomGenerator.nextInt(lklass.size()));
            int modeint = randomGenerator.nextInt(3);
            switch (modeint) {
                case 0:
                    ge.mode = LessonMode.CM;
                    break;
                case 1:
                    ge.mode = LessonMode.TD;
                    break;
                default:
                    ge.mode = LessonMode.ELEARNING;
            }
            //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
            DateTime dt = new DateTime(thisyear, thismonth + randomGenerator.nextInt(2), thisday + randomGenerator.nextInt(20), 9 + randomGenerator.nextInt(5), 0, 0, 0);
            ge.start = dt.getMillis();
            dt.plusHours(randomGenerator.nextInt(2));
            ge.end = dt.getMillis();

            ge.name = "learn : " + ge.lesson.name;


            ge.save();
        }

        List<Person> listofperson = Person.findAll();
        for (int i = 0; i < 350; i++) {
            PersoEvent ge = new PersoEvent();
            ge.person = listofperson.get(randomGenerator.nextInt(listofperson.size()));

            //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
            DateTime dt = new DateTime(thisyear, thismonth + randomGenerator.nextInt(2), thisday + randomGenerator.nextInt(20), 9 + randomGenerator.nextInt(5), 0, 0, 0);
            ge.start = dt.getMillis();
            dt.plusHours(randomGenerator.nextInt(2));
            ge.end = dt.getMillis();

            ge.name = "a personal think";
            ge.description = "think about fish";


            ge.save();
        }
        List<Student> liststudent = Student.findAll();
        for (int i = 0; i < 200; i++) {
            OralEvalEvent ge = new OralEvalEvent();
            ge.student = liststudent.get(randomGenerator.nextInt(liststudent.size()));
            ge.lesson = listlesson.get(randomGenerator.nextInt(listlesson.size()));

            //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
            DateTime dt = new DateTime(thisyear, thismonth + randomGenerator.nextInt(2), thisday + randomGenerator.nextInt(20), 9 + randomGenerator.nextInt(5), 0, 0, 0);
            ge.start = dt.getMillis();
            dt.plusHours(randomGenerator.nextInt(2));
            ge.end = dt.getMillis();

            ge.name = "ORAL : " + ge.lesson.name;
            ge.description = "test it";


            ge.save();
        }

        for (int i = 0; i < 200; i++) {
            PracticalEvalEvent ge = new PracticalEvalEvent();
            ge.klass = lklass.get(randomGenerator.nextInt(lklass.size()));
            ge.lesson = listlesson.get(randomGenerator.nextInt(listlesson.size()));

            //    ge.interval = new Interval(new DateTime(), new DateTime((new DateTime()).getMillis() + (3600 * 1000)));
            DateTime dt = new DateTime(thisyear, thismonth + randomGenerator.nextInt(2), thisday + randomGenerator.nextInt(20), 9 + randomGenerator.nextInt(5), 0, 0, 0);
            ge.start = dt.getMillis();
            dt.plusHours(randomGenerator.nextInt(2));
            ge.end = dt.getMillis();

            ge.name = "TP : " + ge.lesson.name;
            ge.description = "fear";


            ge.save();
        }

    }
}
