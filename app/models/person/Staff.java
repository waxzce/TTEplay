/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import models.Campus;
import models.event.Event;

/**
 *
 * @author waxzce
 */
@Entity
public class Staff extends Person {

    @ManyToOne
    public Campus campus;

    public List<Event> getCalendar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
