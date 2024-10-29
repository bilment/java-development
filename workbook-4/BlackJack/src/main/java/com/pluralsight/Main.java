package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("Enter the name of the first player: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter the name of the second player: ");
        String player2Name = scanner.nextLine();

        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();


        player1Hand.deal(deck.deal());
        player1Hand.deal(deck.deal());
        player2Hand.deal(deck.deal());
        player2Hand.deal(deck.deal());


        System.out.println(player1Name + " has:");
        player1Hand.print();
        System.out.println("Total value: " + player1Hand.getValue());

        System.out.println(player2Name + " has:");
        player2Hand.print();
        System.out.println("Total value: " + player2Hand.getValue());

        int player1Value = player1Hand.getValue();
        int player2Value = player2Hand.getValue();

        if (player1Value > 21 && player2Value > 21) {
            System.out.println("All players are more than 21. No one win.");
        } else if (player1Value > 21) {
            System.out.println(player2Name + " win!");
        } else if (player2Value > 21) {
            System.out.println(player1Name + " win!");
        } else if (player1Value > player2Value) {
            System.out.println(player1Name + " win!");
        } else if (player2Value > player1Value) {
            System.out.println(player2Name + " win!");
        } else {
            System.out.println("Draw!");
        }

        scanner.close();
    }
}
