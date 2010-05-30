/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import models.Promo;

/**
 *
 * @author waxzce
 */
@Entity
public class Student extends Person {

    @ManyToOne
    public Promo promo;
}
