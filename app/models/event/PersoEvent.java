/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import models.Campus;
import models.person.Person;
import play.data.validation.MaxSize;
import play.data.validation.Required;

/**
 *
 * @author waxzce
 */
@Entity
public class PersoEvent extends Event {

    @Required
    @ManyToOne
    public Person person;
    @Lob
    @MaxSize(10000)
    public String description;
}
