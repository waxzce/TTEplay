/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event.eval;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import models.Campus;
import models.Promo;
import play.data.validation.Required;

/**
 *
 * @author waxzce
 */
@Entity
public class OralEvalEvent extends EvaluationEvent {

   @Required
   @ManyToOne
   public Promo promo;

}
