/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event.eval;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import models.Campus;
import models.Promo;
import models.person.Student;
import play.data.validation.Required;
import play.db.jpa.JPA;

/**
 *
 * @author waxzce
 */
@Entity
public class OralEvalEvent extends EvaluationEvent {

    @Required
    @ManyToOne
    public Student student;

   public static List<OralEvalEvent> findForCampus(Campus campus) {
        EntityManager em = JPA.em();
        //  List l = em.createQuery("from CampusEvent ce, ExamEvent ee, GlobalEvent ge, LessonEvent le, PersoEvent pe where ce.campus = :campus").setParameter("campus", s.promo.campus).getResultList();
        List<OralEvalEvent> l = em.createQuery("from OralEvalEvent e where student.klass.campus = :campus").setParameter("campus", campus).getResultList();
        return l;
    }
}
