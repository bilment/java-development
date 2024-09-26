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


        System.out.println("Name: " + name + " And salary: " + (hours * payRate));





    }
}
