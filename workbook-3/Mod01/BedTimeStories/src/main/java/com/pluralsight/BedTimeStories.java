package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedTimeStories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the of a story: ");
        String fileName = scanner.nextLine();

        try {
            FileInputStream file = new FileInputStream(fileName);
            Scanner fileScanner = new Scanner(file);
            int lineNumber = 1;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.printf("%d. %s%n", lineNumber, line);
                lineNumber++;
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the file " + fileName + " could not be found.");
            e.printStackTrace();

        }

    }
}
