package com.pluralsight;

import java.util.Scanner;

public class Conditional {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your age: ");
        int age = input.nextInt();

        double price =  (age < 18) ? 22.50 : 25.00;
        System.out.println(price);



//        if (age < 18) {
//            System.out.println("You get a %50 discount");
//        } else if (age < 65) {
//            System.out.println("You get a %30 discount");
//        } else {
//            System.out.println("You get a %10 discount");
//        }

//        if (age < 18 || age >= 65) {
//            price = 18.00;
//        } else {
//            price = 25.00;
//        }
//        System.out.println(price);
//        if (name.equalsIgnoreCase("Raymond")) {
//            System.out.println("I love potatoes");
//        }
    }
}
