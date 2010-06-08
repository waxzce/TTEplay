/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import play.mvc.*;
import play.*;
import controllers.CRUD;
import java.util.List;
import models.event.*;
import play.db.jpa.JPASupport;
import play.exceptions.TemplateNotFoundException;
import sun.tools.tree.SuperExpression;

/**
 *
 * @author waxzce
 */
@CRUD.For(PersoEvent.class)
@With(Secure.class)
public class CRUDPersoEvents extends CRUD {

    public static void list(int page, String search, String searchFields, String orderBy, String order) {
        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        if (page < 1) {
            page = 1;
        }
        String where = (String) request.args.get("where");
        where = (where != null ? where + " and " : "") + "person.id=" + Security.get().id.toString();
        List<JPASupport> objects = type.findPage(page, search, searchFields, orderBy, order, where);
        Long count = type.count(search, searchFields, where);
        Long totalCount = type.count(null, null, where);
        try {
            render(type, objects, count, totalCount, page, orderBy, order);
        } catch (TemplateNotFoundException e) {
            render("CRUD/list.html", type, objects, count, totalCount, page, orderBy, order);
        }


    }
}
