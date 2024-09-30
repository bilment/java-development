package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

        System.out.println("Employee name: ");
        String name = input.nextLine();

        System.out.println("How many hours worked?");
        float hours = input.nextFloat();

        System.out.println("Enter pay rate: ");
        float payRate = input.nextFloat();

        double grossPay;
            if (hours>40) {
                grossPay = 40 * payRate + (hours - 40) * 1.5 * payRate;
            }else {
                grossPay = hours * payRate;
            }

        System.out.println("Name: " + name);
        System.out.println("Gross Pay: $" + String.format("%.2f", grossPay));





    }
}
