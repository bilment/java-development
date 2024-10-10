package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {

        CellPhone cellPhone1 = new CellPhone();
        Scanner scanner = new Scanner(System.in);


        System.out.print("What is the serial number of the first phone? ");
        int serialNumber = scanner.nextInt();
        cellPhone1.setSerialNumber(serialNumber);
        scanner.nextLine();

        System.out.print("What model is the first phone? ");
        String model = scanner.nextLine();
        cellPhone1.setModel(model);

        System.out.print("Who is the carrier of the first phone? ");
        String carrier = scanner.nextLine();
        cellPhone1.setCarrier(carrier);

        System.out.print("What is the phone number of the first phone? ");
        String phoneNumber = scanner.nextLine();
        cellPhone1.setPhoneNumber(phoneNumber);

        System.out.print("Who is the owner of the first phone? ");
        String owner = scanner.nextLine();
        cellPhone1.setOwner(owner);


        CellPhone cellPhone2 = new CellPhone();


        System.out.print("\nWhat is the serial number of the second phone? ");
        serialNumber = scanner.nextInt();
        cellPhone2.setSerialNumber(serialNumber);
        scanner.nextLine();

        System.out.print("What model is the second phone? ");
        model = scanner.nextLine();
        cellPhone2.setModel(model);

        System.out.print("Who is the carrier of the second phone? ");
        carrier = scanner.nextLine();
        cellPhone2.setCarrier(carrier);

        System.out.print("What is the phone number of the second phone? ");
        phoneNumber = scanner.nextLine();
        cellPhone2.setPhoneNumber(phoneNumber);

        System.out.print("Who is the owner of the second phone? ");
        owner = scanner.nextLine();
        cellPhone2.setOwner(owner);


        CellPhone cellPhone3 = new CellPhone(34567, "iPhone 14", "Verizon", "555-1234", "Raymond");


        display(cellPhone1);
        display(cellPhone2);
        display(cellPhone3);


        cellPhone1.dial(cellPhone2.getPhoneNumber());
        cellPhone2.dial(cellPhone1.getPhoneNumber());


        cellPhone1.dial(cellPhone3);
        cellPhone3.dial(cellPhone1);


        scanner.close();
    }


    public static void display(CellPhone phone) {
        System.out.println("\nCellPhone Details:");
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Model: " + phone.getModel());
        System.out.println("Carrier: " + phone.getCarrier());
        System.out.println("Phone Number: " + phone.getPhoneNumber());
        System.out.println("Owner: " + phone.getOwner());
    }
}
