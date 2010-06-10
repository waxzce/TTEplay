/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import models.person.Person;
import play.data.validation.Check;

/**
 *
 * @author waxzce
 */
public class PersoEventPersonValidation extends Check {

    public boolean isSatisfied(Object personevent, Object person) {
        return (controllers.Security.get().id == ((Person) person).id);
    }
}
