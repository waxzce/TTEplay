/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.event.eval.*;
import play.mvc.With;

/**
 *
 * @author waxzce
 */
@CRUD.For(PracticalEvalEvent.class)
@Check("staff")
@With(Secure.class)
public class CRUDPracticalEvalEvents extends CRUD {
}