/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.adminCrud;

import play.mvc.*;
import play.*;
import controllers.CRUD;
import models.Person;

/**
 *
 * @author waxzce
 */
@CRUD.For(Person.class)
public class Persons extends CRUD {
}
