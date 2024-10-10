package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter version1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("Version 1: " + now.format(version1));

        DateTimeFormatter version2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Version 2: " + now.format(version2));

        DateTimeFormatter version3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println("Version 3: " + now.format(version3));

        DateTimeFormatter version4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println("Version 4: " + now.format(version4));
    }
}


