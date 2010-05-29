package controllers;

import play.mvc.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        render();
    }
}
