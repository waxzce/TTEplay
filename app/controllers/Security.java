/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author waxzce
 */
import models.person.Person;
import models.*;
import models.person.GlobalStaff;
import models.person.Staff;
import models.person.Student;
import models.person.Teacher;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        return Person.connect(username, password) != null;
    }

    static boolean check(String profile) {
        if ("student".equals(profile)) {
            return (get() instanceof Student);
        }
        if ("staff".equals(profile)) {
            return (get() instanceof Staff);
        }
        if ("teacher".equals(profile)) {
            return (get() instanceof Teacher);
        }
        if ("globalstaff".equals(profile)) {
            return (get() instanceof GlobalStaff);
        }
        return false;
    }

    public static Person get() {
        return Person.get(Security.connected());
    }
}
