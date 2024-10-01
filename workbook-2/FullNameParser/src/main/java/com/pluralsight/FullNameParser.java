package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");

        String fullName = input.nextLine();
        System.out.println(fullName);

        String[] nameParts = fullName.split(" ");


        if (nameParts.length == 2) {

            System.out.println("First name: " + nameParts[0]);
            System.out.println("Middle name: (none)");
            System.out.println("Last name: " + nameParts[1]);
        } else if (nameParts.length == 3) {

            System.out.println("First name: " + nameParts[0]);
            System.out.println("Middle name: " + nameParts[1]);
            System.out.println("Last name: " + nameParts[2]);
        } else {

            System.out.println("Invalid name");
        }
    }
}
