/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.time.Interval;
import play.db.jpa.Model;

/**
 *
 * @author waxzce
 */
@Entity
public abstract class Event extends Model {

    @Columns(columns = {
        @Column(name = "startTime"),
        @Column(name = "endTime")})
    @Type(type = "org.joda.time.contrib.hibernate.PersistentInterval")
    public Interval interval;
}
