/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import models.event.Event;
import play.db.jpa.JPA;

/**
 *
 * @author waxzce
 */
@Entity
public class GlobalStaff extends Person {

    public List<Event> getCalendar() {
        EntityManager em = JPA.em();
        //  List l = em.createQuery("from CampusEvent ce, ExamEvent ee, GlobalEvent ge, LessonEvent le, PersoEvent pe where ce.campus = :campus").setParameter("campus", s.promo.campus).getResultList();
        List<Event> l = em.createQuery("from Event e where e.global = true OR e.person = :person").setParameter("person", this).getResultList();
        return l;
    }
}
