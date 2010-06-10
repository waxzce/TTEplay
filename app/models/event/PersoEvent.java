/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event;

import controllers.Security;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import models.Campus;
import models.person.Person;
import play.data.validation.Check;
import play.data.validation.CheckWith;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.JPASupport;
import validation.PersoEventPersonValidation;

/**
 *
 * @author waxzce
 */
@Entity
public class PersoEvent extends Event {

    @Required
    @ManyToOne
    @CheckWith(PersoEventPersonValidation.class)
    public Person person;
    @Lob
    @MaxSize(10000)
    public String description;
}
