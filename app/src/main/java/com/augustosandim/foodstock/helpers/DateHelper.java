package com.augustosandim.foodstock.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by augustosandim on 16/02/16.
 */
public class DateHelper {
    public static Date formatDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
