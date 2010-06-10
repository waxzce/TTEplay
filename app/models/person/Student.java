/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import models.Campus;
import models.Klass;
import models.Promo;
import models.event.Event;
import play.db.jpa.JPA;

/**
 *
 * @author waxzce
 */
@Entity
public class Student extends Person {

    @ManyToOne
    public Klass klass;

    public List<Event> getCalendar() {
        EntityManager em = JPA.em();
        //  List l = em.createQuery("from CampusEvent ce, ExamEvent ee, GlobalEvent ge, LessonEvent le, PersoEvent pe where ce.campus = :campus").setParameter("campus", s.promo.campus).getResultList();
        List<Event> l = em.createQuery("from Event e where e.global = true OR e.person = :person OR e.promo = :promo OR e.campus = :campus OR e.klass = :klass").setParameter("person", this).setParameter("promo", this.klass.promo).setParameter("klass", this.klass).setParameter("campus", this.klass.campus).getResultList();
        return l;
    }

    public static List<Student> findStudentForCampus(Campus campus) {
        EntityManager em = JPA.em();
        //  List l = em.createQuery("from CampusEvent ce, ExamEvent ee, GlobalEvent ge, LessonEvent le, PersoEvent pe where ce.campus = :campus").setParameter("campus", s.promo.campus).getResultList();
        List<Student> l = em.createQuery("from Student s where s.klass.campus = :campus").setParameter("campus", campus).getResultList();
        return l;
    }
}
