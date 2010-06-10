/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import play.data.validation.*;
import play.db.jpa.JPA;
import play.db.jpa.Model;

/**
 *
 * @author waxzce
 */
@Entity
public class Klass extends Model {

    @Required
    public String name;
    @ManyToOne
    @Required
    public Promo promo;
    @ManyToOne
    @Required
    public Campus campus;


    public static List<Klass> findForCampus(Campus campus) {
        EntityManager em = JPA.em();
        //  List l = em.createQuery("from CampusEvent ce, ExamEvent ee, GlobalEvent ge, LessonEvent le, PersoEvent pe where ce.campus = :campus").setParameter("campus", s.promo.campus).getResultList();
        List<Klass> l = em.createQuery("from Klass k where campus = :campus").setParameter("campus", campus).getResultList();
        return l;
    }
}
