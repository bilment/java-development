package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {

        /* String stringInt = "111";
        int parsedInt = Integer.parseInt(stringInt);

        int result = parsedInt + 1;


        String stringDouble = "111.22";
        double parsedDouble = Double.parseDouble(stringDouble);
        */


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.println("What date will you be coming (MM/dd/yyyy):");
        String userInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate theaterDay = LocalDate.parse(userInput, formatter);

        System.out.println("How many ticket you want?");
        int ticket = scanner.nextInt();


        System.out.println(ticket + " tickets reserved for " + theaterDay + "under" + name);



    }
}
