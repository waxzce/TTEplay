/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import models.Campus;
import play.data.validation.Required;

/**
 *
 * @author waxzce
 */
@Entity
public class GlobalEvent extends Event {

    @Required
    public String name;
    @Lob
    public String description;
    public Boolean global = true;
}
