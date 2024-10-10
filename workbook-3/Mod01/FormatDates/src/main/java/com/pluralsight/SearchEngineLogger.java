package com.pluralsight;

import java.io.FileWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void logAction(String action) {
        try (FileWriter writer = new FileWriter("logs.txt", true)) {

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String logEntry = now.format(dtf) + " " + action + "\n";
            writer.write(logEntry);

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        logAction("Launch");

        Scanner scanner = new Scanner(System.in);

        String searchTerm;

        while (true) {
            System.out.print("Enter a search term (X to exit): ");
            searchTerm = scanner.nextLine();

            if (searchTerm.equalsIgnoreCase("X")) {
                logAction("exit");
                System.out.println("Exiting the application.");
                break;
            }

            logAction("search : " + searchTerm);
            System.out.println("Searching for: " + searchTerm);
        }

        scanner.close();
    }
}
