package com.utility;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ToDoUtils {
    public static LocalDate convertStringToDate(String stringDate) {
        try {
            return LocalDate.parse(stringDate);
        } catch (DateTimeException e) {
            System.out.println("INVALID DATE ENTERED, SO THE PROGRAM IS TERMINATING");
            throw new IllegalArgumentException(e);
        }


    }
}
