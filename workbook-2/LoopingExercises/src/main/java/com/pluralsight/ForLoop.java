package com.pluralsight;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 10; i > 0; i--) {
            System.out.println("Number: " + i);
            Thread.sleep(1000);
        }
        System.out.println("Launch!");
    }
}
