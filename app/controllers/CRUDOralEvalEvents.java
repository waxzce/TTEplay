/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.event.eval.*;
import play.mvc.*;
import controllers.CRUD;
import java.util.List;
import models.person.Staff;
import play.db.jpa.JPASupport;
import play.exceptions.TemplateNotFoundException;

/**
 *
 * @author waxzce
 */
@CRUD.For(OralEvalEvent.class)
@Check("staff")
@With(Secure.class)
public class CRUDOralEvalEvents extends CRUD {

    public static void list(int page, String search, String searchFields, String orderBy, String order) {

        ObjectType type = ObjectType.get(getControllerClass());
        notFoundIfNull(type);
        if (page < 1) {
            page = 1;
        }
        String where = (String) request.args.get("where");

        if (Security.check("localstaff")) {
            where = (where != null ? where + " and " : "");
            where = where + "student.klass.campus.id=" + ((Staff) Security.get()).campus.id.toString();
        }
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