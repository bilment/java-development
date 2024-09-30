package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter Sandwich size: 1 or 2:");
        System.out.println("1.Regular Sandwich\n2.Large Sandwich");
        double regularSandwich = 5.45;
        double largeSandwich = 8.95;
        double firstChoose = input.nextDouble();

        System.out.println("How old are you?");
        int customerAge = input.nextInt();
        if (customerAge <= 17) {
            System.out.println("You have %10 discount.");
        } else if (customerAge >= 65) {
            System.out.println("You have %20 discount.");
        } else {
            System.out.println("You don't have any discount.");
        }

        double currentPrice = 5.45 - (5.45 * 0.10);
        double currentPrice2 = 8.95 - (8.95 * 0.20);
        double currentPrice3 = 5.45 - (5.45 * 0.10);
        double currentPrice4 =  8.95 - (8.95 * 0.20);

        if (firstChoose == 1) {
            if (customerAge <= 17) {
                System.out.println("Your price is 5.45 but you got %10 discount, total price is: " + currentPrice);
            } else if (customerAge >= 65) {
                System.out.println("Your price is 8.95 but you got %20 discount, total price is: " + currentPrice2);
            } else {
                System.out.println("Here is your price: " + regularSandwich);
            }
        } if (firstChoose == 2) {
            if (customerAge <= 17) {
                System.out.println("Your price is 8.95 but you got %10 discount, total price is: " + currentPrice3);
            } else if (customerAge >= 65) {
                System.out.println("Your price is 8.95 but you got %20 discount, total price is: " + currentPrice4);
            } else {
                System.out.println("Here is your price: " + largeSandwich);
            }
        }
        System.out.println("Thank you for choosing us.");
    }
}
