/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.person.Teacher;
import play.mvc.*;
import play.*;
import controllers.CRUD;
import models.*;

/**
 *
 * @author waxzce
 */
@CRUD.For(Teacher.class)
@Check("staff")
public class CRUDTeachers extends CRUD {
}
