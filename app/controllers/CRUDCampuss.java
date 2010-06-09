/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import play.mvc.*;
import play.*;
import controllers.CRUD;
import models.*;

/**
 *
 * @author waxzce
 */
@CRUD.For(Campus.class)
@Check("globalstaff")
@With(Secure.class)
public class CRUDCampuss extends CRUD {
}
