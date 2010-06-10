/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import models.Campus;
import models.Klass;
import models.Lesson;
import models.Promo;
import models.i.LessonMode;
import models.person.Teacher;
import play.data.validation.Required;

/**
 *
 * @author waxzce
 */
@Entity
public class LessonEvent extends Event {

    @Required
    @ManyToOne
    public Klass klass;
    @ManyToOne
    public Teacher teacher;
    @Required
    @ManyToOne
    public Lesson lesson;
    @Required
    public LessonMode mode;
}
