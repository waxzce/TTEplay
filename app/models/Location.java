/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 *
 * @author waxzce
 */
@Entity
public class Location extends Model {

    @Required
    public String name;
    @Required
    @ManyToOne
    public Campus campus;
}
