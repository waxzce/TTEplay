/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author waxzce
 */
@Entity
public class Staff extends Person {

    @ManyToOne
    Campus campus;


}
