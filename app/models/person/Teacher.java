/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import models.Lesson;
import models.event.Event;
import play.db.jpa.JPA;

/**
 *
 * @author waxzce
 */
@Entity
public class Teacher extends Person {

    @ManyToOne
    public Lesson lesson;

    public List<Event> getCalendar() {
        EntityManager em = JPA.em();
        List<Event> l = em.createQuery("from Event e where e.global = true OR e.person = :perso OR e.teacher = :teacher").setParameter("teacher", this).setParameter("perso", this).getResultList();
        return l;
    }
}
