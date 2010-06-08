/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.person.GlobalStaff;
import play.mvc.*;
import play.*;
import controllers.CRUD;
import models.*;

/**
 *
 * @author waxzce
 */
@CRUD.For(GlobalStaff.class)
@Check("globalstaff")
@With(Secure.class)
public class CRUDGlobalStaffs extends CRUD {
}
