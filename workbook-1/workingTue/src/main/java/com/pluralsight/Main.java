package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fullName = "Raymond Maroun";

        int length = fullName.length(); //karakter sayisi
        System.out.println(length);

        System.out.println("=========================");

        String username = "     danaw         ";
        System.out.println(username);

        String trimmedUsername = username.trim();
        System.out.println(trimmedUsername);

        System.out.println("=========================");

        String name = "raymond";
        System.out.println(name.toUpperCase());

        System.out.println("=========================");

        String newName = "KATE";
        System.out.println(name.toLowerCase());

        System.out.println("=========================");

        String instructorName = "     raymond    ";
        System.out.println(instructorName.trim().toUpperCase());

        System.out.println("=========================");

        String testString = "      Hello Cameron how are you?   ";
        System.out.println(testString.trim());

        System.out.println("=========================");

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter a name to check");
//        String secondName = scanner.nextLine();

//        if (secondName.startsWith("Ra")) {
//            System.out.println("This is true!");
//        }
        System.out.println("=========================");

        String discountCode = "SAVE-50";

        if (discountCode.endsWith("-50")) {
            System.out.println("This is true");
        }

        System.out.println("=========================");

        String product = "Chips";
        char letter = product.charAt(2);
        System.out.println(letter);

        System.out.println("=========================");

        String productCode = "ACME-122213";
        int dashPosition = productCode.indexOf("-");
        System.out.println(dashPosition);

        System.out.println("=========================");

        String teacherName = "Raymond";
        String nickName = teacherName.substring(0,3);
        System.out.println(nickName);

        nickName = teacherName.substring(3);
        System.out.println(nickName);

        System.out.println("=========================");

        String input = "Dallas|Ft. Worth|Austin";
        String[] cities = input.split("t");
        for (String city : cities) {
            System.out.println(city);


        }
    }
}