/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import play.data.validation.*;
import play.db.jpa.Model;

/**
 *
 * @author waxzce
 */
@Entity
public class Promo extends Model {

    @Required
    public String name;
    @ManyToOne
    @Required
    public Campus campus;
}
