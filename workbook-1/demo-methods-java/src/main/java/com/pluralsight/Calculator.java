package com.pluralsight;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double a = input.nextDouble();

        System.out.println("Enter second number: ");
        double b = input.nextDouble();

        System.out.println("1.Add\n2.Subs\n3.Multiply\n4.Divide");
        System.out.println("Which method you want to use?");

        int c = input.nextInt();
        if (c == 1) {
            add(a, b);
        } else if (c == 2) {
            subs(a, b);
        } else if (c == 3) {
            multiply(a, b);
        } else if (c == 4) {
            divide(a, b);
        } else {
            System.out.println("You entered wrong character!");
        }


    }

    public static void add(double a, double b) {
        System.out.println("Add: " + (a + b));

    }

    public static void subs(double a, double b) {
        System.out.println("Subtraction: " + (a - b));

    }

    public static void multiply(double a, double b) {
        System.out.println("Multiply: " + (a * b));

    }

    public static void divide(double a, double b) {
        System.out.println("Divide: " + (a / b));
    }
}
