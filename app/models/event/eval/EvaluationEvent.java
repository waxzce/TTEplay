/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event.eval;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import models.Campus;
import models.Klass;
import models.Lesson;
import models.Promo;
import models.event.Event;
import play.data.validation.Required;

/**
 *
 * @author waxzce
 */
@Entity
public abstract class EvaluationEvent extends Event {

    @Lob
    public String description;
    @Required
    @ManyToOne
    public Lesson lesson;
}
