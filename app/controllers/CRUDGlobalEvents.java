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
@CRUD.For(GlobalEvent.class)
@Check("globalstaff")
@With(Secure.class)
public class CRUDGlobalEvents extends CRUD {
}
