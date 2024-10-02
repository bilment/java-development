package com.pluralsight;

import java.util.Scanner;

public class SwitchStatements {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the day you want: ");
        int dayNumber = input.nextInt();
        String dayName = "";

        switch (dayNumber) {
            case 0: // if (dayNumber == 0);
                dayName = "Sunday";
                break;
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            default:
                System.out.println("Invalid Input!");
                return;
        }
        System.out.println("The name of the day is: " + dayName);
    }
}

