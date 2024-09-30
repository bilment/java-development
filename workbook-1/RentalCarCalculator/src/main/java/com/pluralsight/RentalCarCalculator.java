package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter pickup date: ");
        String pickupDate = scanner.nextLine();

        System.out.print("Enter number of rental days: ");
        int rentalDays = scanner.nextInt();

        System.out.print("Would you like an electronic toll tag? (yes/no): ");
        boolean tollTag = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Would you like a GPS? (yes/no): ");
        boolean gps = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Would you like roadside assistance? (yes/no): ");
        boolean roadsideAssistance = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        final double basicRentalDate = 29.99;
        final double tollTagRate = 3.95;
        final double gpsRate = 2.95;
        final double roadAssistanceRate = 3.95;
        final double underageSurchargeRate = 0.30;


        double basicRentalCost = basicRentalDate * rentalDays;


        double optionsCost = 0;
        if (tollTag) {
            optionsCost += tollTagRate * rentalDays;
        }
        if (gps) {
            optionsCost += gpsRate * rentalDays;
        }
        if (roadsideAssistance) {
            optionsCost += roadAssistanceRate * rentalDays;
        }


        double underageSurcharge = 0;
        if (age < 25) {
            underageSurcharge = basicRentalCost * underageSurchargeRate;
        }


        double totalCost = basicRentalCost + optionsCost + underageSurcharge;


        System.out.println("Basic car rental: $" + String.format("%.2f", basicRentalCost));
        System.out.println("Options cost: $" + String.format("%.2f", optionsCost));
        if (age < 25) {
            System.out.println("Underage driver surcharge: $" + String.format("%.2f", underageSurcharge));
        }
        System.out.println("Total cost: $" + String.format("%.2f", totalCost));
    }
}
