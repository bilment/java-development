package com.pluralsight;

public class Arrays {
    public static void main(String[] args) {

        int firstNumber = 1;
        int[] listOfNumber = {63, 65, 60, 53, 58, 37, 35, 31};
        String[] listOfNames = {"Ray", "Devin", "Joseph"};

        System.out.println("The second name of the list: " + listOfNames[1]);

        listOfNames[1] = "Raymond";

        System.out.println("The second name of the list: " + listOfNames[1]);

        System.out.println("The array of the numbers have " + listOfNumber.length + " elements.");

        for (int i = 0; i < listOfNumber.length; i++) {
            System.out.println(listOfNumber[i]);
            
        }

        int[] newArrayOfNumber = new int[5];

        for (int i = 0; i < newArrayOfNumber.length; i++) {
            System.out.print(newArrayOfNumber[i] + " ");

            newArrayOfNumber[2] = 3;
        }
        System.out.println();

        System.out.println("=================================");

        for(String name : listOfNames) {
            System.out.println(name);
        }

        System.out.println("=================================");

        int[] nums = {63, 65, 60, 53, 58, 37, 35, 31};
        displayNumber(nums);

        System.out.println("=================================");

        int[] arrayFromFunction = getNumbers();
        displayNumber(arrayFromFunction);

    }
    public static void displayNumber(int[] listOfNumbers) {
        for (int i = 0; i < listOfNumbers.length; i++) {
            System.out.print(listOfNumbers[i] + " ");
            
        }
        System.out.println();
    }

    public static int[] getNumbers() {
        int[] nums = {35,52,23,43,25};
        return nums;
    }

}
