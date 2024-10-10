package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;


public class SearchInventory {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventoryFromFile("inventory.csv");
        if (inventory == null) {
            System.out.println("Failed to load inventory from file.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("What do you want to do?");
            System.out.println("1 - List all products");
            System.out.println("2 - Lookup a product by its ID");
            System.out.println("3 - Find all products within a price range");
            System.out.println("4 - Add a new product");
            System.out.println("5 - Quit the application");
            System.out.print("Enter command: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    inventory.sort(Comparator.comparing(Product::getName));
                    System.out.println("We carry the following inventory:");
                    for (Product p : inventory) {
                        System.out.printf("id: %d %s - Price: $%.2f%n", p.getId(), p.getName(), p.getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    Product product = findProductById(inventory, id);
                    if (product != null) {
                        System.out.printf("Found: %s - Price: $%.2f%n", product.getName(), product.getPrice());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter minimum price: ");
                    float minPrice = scanner.nextFloat();
                    System.out.print("Enter maximum price: ");
                    float maxPrice = scanner.nextFloat();
                    findProductsByPriceRange(inventory, minPrice, maxPrice);
                    break;
                case 4:
                    System.out.print("Enter product ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter product name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    float newPrice = scanner.nextFloat();
                    inventory.add(new Product(newId, newName, newPrice));
                    System.out.println("Product added successfully.");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    public static ArrayList<Product> getInventoryFromFile(String fileName) {
        ArrayList<Product> inventory = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    float price = Float.parseFloat(parts[2].trim());
                    inventory.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return inventory;
    }

    public static Product findProductById(ArrayList<Product> inventory, int id) {
        for (Product p : inventory) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static void findProductsByPriceRange(ArrayList<Product> inventory, float minPrice, float maxPrice) {
        System.out.printf("Products between $%.2f and $%.2f:%n", minPrice, maxPrice);
        for (Product p : inventory) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                System.out.printf("id: %d %s - Price: $%.2f%n", p.getId(), p.getName(), p.getPrice());
            }
        }
    }
}
