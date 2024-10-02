package com.pluralsight;

import java.util.Scanner;

public class MyApplication {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = getName(input);
        int age = getAge(input);

        printNameAndAge(name, age);
        System.out.println("===================");
        printVotingEligibility(name, age);
        System.out.println("===================");
        printMessage(name, age);
        System.out.println("===================");
        printWelcomeMessage(name);
        System.out.println("===================");
        printDrinkingEligibility(name, age);
        System.out.println("===================");
        double number = getNumber(input);
        double squareRoot = calculateSquareRoot(number);
        System.out.println("The square root of " + number + " is " + squareRoot);
        System.out.println("===================");
        int firstNumber = getFirstNumber(input);
        int secondNumber = getSecondNumber(input);
        boolean isGreaterThan = isGreaterThan(firstNumber,secondNumber);
        System.out.println(firstNumber + " is greater than " + secondNumber + ":" + isGreaterThan);
        System.out.println("===================");

        String welcomeMessage = name.equalsIgnoreCase("Eve") ? "You are not welcome, " + name + "!" : "Welcome " + name + "!";
        System.out.println(welcomeMessage);
        System.out.println("===================");
        double num1 = 10;
        double num2 = 20;
        double maxNum = getMax(num1,num2);
        System.out.println("The maximum of " + num1 + " and " + num2 + " is " + maxNum);
        System.out.println("===================");

        int randomNum = generateRandomNumber();
        System.out.println("Random number between 1 and 10: " + randomNum);
        System.out.println("===================");
        double minNumber1 = 5;
        double minNumber2 = 10;
        double minNum = getMin(minNumber1, minNumber2);
        System.out.println("The smaller number is: " + minNum);

    }
    public static double getMin(double num1, double num2) {
        return Math.min(num1, num2);
    }
    public static int generateRandomNumber() {
        return (int) (Math.random() * 10) + 1; // (int) (Math.random() * (max - min) + 1) + min;
    }
    public static double getMax(double firstNumber, double secondNumber) {
        return Math.max(firstNumber, secondNumber);
    }
    public static int getFirstNumber(Scanner input) {
        System.out.println("Enter the first number: ");
        return input.nextInt();
    }
    public static int getSecondNumber(Scanner input) {
        System.out.println("Enter the second number: ");
        return input.nextInt();
    }
    public static boolean isGreaterThan(int firstNumber, int secondNumber) {
//        if(firstNumber > secondNumber) {
//            return true;
//        } else {
//            return false;
//        }
        return firstNumber > secondNumber;
    }
    public static double calculateSquareRoot(double number) {
        return Math.sqrt(number);
    }
    public static double getNumber(Scanner input) {
        System.out.println("Enter your number: ");
        return input.nextDouble();
    }
    public static void printDrinkingEligibility(String name, int age) {
        if (name.equalsIgnoreCase("Bob") && age >= 21) {
            System.out.println("You are old enough to vote!");
        } else {
            System.out.println("You are not old enough to vote!");
        }
    }
//    public static void printWelcomeMessage(String name) {
//        if (name.equalsIgnoreCase("Alice")) {
//            System.out.println("Welcome, Alice!");
//        }else {
//            System.out.println("Hello, stranger!");
//        }
//    }
    public static void printWelcomeMessage(String name) {
        switch (name.toLowerCase()) {
            case "alice":
                System.out.println("Welcome, Alice!");
                break;
            case "bob":
                System.out.println("Hey Bob, do you want to grab a drink?");
                break;
            default:
                System.out.println("Hello, stranger!");
                break;
        }
    }
    public static void printVotingEligibility (String name, int age) {
        if (age >= 18) {
            System.out.println("Hello " + name + ", you are old enough to vote.");
        } else {
            System.out.println("Hello " + name + ", you are not old enough to vote.");
        }
    }
    public static void printNameAndAge(String name, int age) {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
    }
    public static int getAge(Scanner input) {
        System.out.println("What is your age?");
        return input.nextInt();

    }
    public static String getName(Scanner input) {
        System.out.println("What is your name?");
        return input.nextLine(); // String name = input.nextLine(); return name;

    }
    public static void printMessage(String name, int age) {
        System.out.println("Hello " + name + ", you are " + age + " years old.");

    }


}
