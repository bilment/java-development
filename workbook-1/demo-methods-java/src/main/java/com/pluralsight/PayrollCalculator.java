package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Employee name: ");
        String name = input.nextLine();

        System.out.println("How many hours worked?");
        double hours = input.nextDouble();

        System.out.println("Enter pay rate: ");
        double rate = input.nextDouble();

        double regularPay = calculateRegularPay(rate, hours);
        double overtimePay = calculateOvertimePay(rate, hours);

        double totalPay = regularPay + overtimePay;

        System.out.println("The total pay for " + name + " is $" + totalPay);
    }

    public static double calculateRegularPay(double rate, double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * rate;
        } else {
            return 40 * rate;
        }
    }

    public static double calculateOvertimePay(double rate, double hoursWorked) {
        if (hoursWorked > 40) {
            return (hoursWorked - 40) * 1.5 * rate;
        } else {
            return 0;
        }
    }
}
