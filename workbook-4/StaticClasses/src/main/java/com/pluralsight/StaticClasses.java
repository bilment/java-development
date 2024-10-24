package com.pluralsight;
import java.util.Scanner;
public class StaticClasses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Please enter your Prefix (Mr., Mrs.) : ");
        String prefix = scanner.nextLine();

        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Please enter your middle name: ");
        String middleName = scanner.nextLine();


        System.out.println("Please enter your suffix (Phd, Jr) ");
        String suffix = scanner.nextLine();

        String fullName = NameFormatter.format(prefix, firstName, middleName, lastName, suffix );
        System.out.println(fullName);


    }
}