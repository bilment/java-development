package com.pluralsight;

public class Main3 {
    public static void main(String[] args) {
        String[] colors = {"red", "white", "blue"};
        String[] copy = new String[3];

        // copy = colors;
        System.arraycopy(colors, 2, copy, 1, 1);

        System.out.println("Colors: ");
        for (String color : colors) {
            System.out.println(color);
        }
        System.out.println();

        colors[1] = "yellow";
        System.out.println("Colors: ");
        for (String color : colors) {
            System.out.println(color);
        }
        System.out.println();

        System.out.println("Copy Array: ");
        for (String color : colors) {
            System.out.println(color);
        }
        System.out.println();

    }
}
