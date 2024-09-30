package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter last name: ");
        String lastName = input.nextLine();

        printFullName(firstName, lastName);

        System.out.println("Enter first number: ");
        int firstNumber = input.nextInt();

        System.out.println("Enter second number: ");
        int secondNumber = input.nextInt();

        int additionResult = add(firstNumber, secondNumber);

        System.out.println(additionResult);


    }

    public static void printFullName(String firstName, String lastName) {
        System.out.println(firstName + " " + lastName);

    }

    public static void printWelcomeMessage() {
        System.out.println("Hello Everyone!");
    }

    public static int add(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

}