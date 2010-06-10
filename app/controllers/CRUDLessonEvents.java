/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.event.*;
import play.mvc.*;
import play.*;
import controllers.CRUD;
import models.*;

/**
 *
 * @author waxzce
 */
@CRUD.For(LessonEvent.class)
@Check("staff")
@With(Secure.class)
public class CRUDLessonEvents extends CRUD {
}
