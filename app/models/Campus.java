/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Entity;
import play.data.validation.*;
import play.db.jpa.Model;

/**
 *
 * @author waxzce
 */
@Entity
public class Campus extends Model {

    @Required
    public String name;

}
