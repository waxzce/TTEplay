/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.joda.time.DateTime;

/**
 *
 * @author waxzce
 */
public class DateUtil {

    public String getDateString(Long millisecond) {
        DateTime d = new DateTime(millisecond);
        return d.toString();
    }
}
