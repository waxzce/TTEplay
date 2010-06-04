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
import models.Promo;
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
    @Required
    @ManyToOne
    public Teacher teacher;
    @Required
    public String name;
    @Lob
    public String description;
}
