package com.example.brentvanvosselen.overtime.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by brentvanvosselen on 19/08/2017.
 */

public final class CustomFunctions {
    private CustomFunctions(){}

    public static String getDateString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
