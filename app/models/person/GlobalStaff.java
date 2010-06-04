/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import models.event.Event;

/**
 *
 * @author waxzce
 */
@Entity
public class GlobalStaff extends Person {

    public List<Event> getCalendar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
