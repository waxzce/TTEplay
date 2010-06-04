/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.person;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import models.i.HaveCalendar;
import play.data.validation.*;
import play.db.jpa.Model;

/**
 *
 * @author waxzce
 */
@Entity
public abstract class Person extends Model implements HaveCalendar {

    @Required
    public String firstName;
    @Required
    public String lastName;
    @Required
    public String login;
    @Required
    @Password
    public String password;
    @Required
    @Email
    public String mail;
    @Required
    @InPast
    public Date dateOfBirth;

    public static Person connect(String username, String password) {
        return Person.find("login = ? AND password = ?", username, password).first();
    }
}
