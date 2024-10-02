package com.pluralsight;

import java.util.Scanner;

public class AdressBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder information = new StringBuilder();

        System.out.println("Full name?");
        String fullName = scanner.nextLine();

        System.out.println("Billing Street?");
        String billingStreet = scanner.nextLine();

        System.out.println("Billing City?");
        String billingCity = scanner.nextLine();

        System.out.println("Billing State?");
        String billingState = scanner.nextLine();

        System.out.println("Billing Zip?");
        String billingZip = scanner.nextLine();

        System.out.println("Shipping Street?");
        String shippingStreet = scanner.nextLine();

        System.out.println("Shipping City?");
        String shippingCity = scanner.nextLine();

        System.out.println("Shipping State?");
        String shippingState = scanner.nextLine();

        System.out.println("Shipping Zip");
        String shippingZip = scanner.nextLine();

        information.append(fullName).append(billingStreet).append(billingCity).append(billingState);

        information.append(billingZip).append(shippingStreet).append(shippingCity).append(shippingState).append(shippingZip);


        System.out.println("Full Name: " + fullName + "\nBilling Street: " + billingStreet);
        System.out.println("Billing City: " + billingCity + "\nBilling State: " + billingState);
        System.out.println("Billing Zip: " + billingZip + "\nShipping Street: " + shippingStreet);
        System.out.println("Shipping City: " + shippingCity + "\nShipping State: " + shippingState + "\nShipping Zip: " + shippingZip);


    }
}
