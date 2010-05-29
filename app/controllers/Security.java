/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author waxzce
 */
import models.*;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        return Person.connect(username, password) != null;
    }

    static boolean check(String profile) {
        if ("user".equals(profile)) {
            return Security.isConnected();
        }
        return false;
    }
}
