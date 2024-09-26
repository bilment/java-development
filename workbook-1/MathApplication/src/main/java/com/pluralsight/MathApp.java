package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {

        int number1 = 27;
        int number2 = 15;
        int result;

        result = number1 + number2;
        System.out.println("Result is: " + result);

        result = number1 - number2;
        System.out.println("Result is: " + result);

        result = number1 * number2;
        System.out.println("Result is: " + result);

        result = number1 / number2;
        System.out.println("Result is: " + result);

        double bobSalary = 5500.0;
        double garySalary = 6750.0;
        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.println(highestSalary);

        double carPrice = 15000.50;
        double truckPrice = 18000.75;
        double minPrice = Math.min(carPrice, truckPrice);
        System.out.println("Smallest price: " + minPrice);

        double radius = 7.25;
        double area = Math.pow(radius, 2);
        System.out.println("Area of the circle: " + area);

        double number = 5.0;
        double squareRoot = Math.sqrt(number);
        System.out.println("Square root of 5.0: " + squareRoot);

        int x1 = 5, y1 = 10, x2= 85, y2= 50;
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Distance: " + distance);

        double number4 = -3.8;
        double absoluteValue = Math.abs(number4);
        System.out.println("Absolute value: " + absoluteValue);


        double randomNumber =Math.random();
        System.out.println("Random number between 0 and 1: " + randomNumber);




    }
}
