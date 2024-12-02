package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static BasicDataSource dataSource;

    public static void main(String[] args) {
        initializeDataSource();

        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nWhat do you want to do?");
                System.out.println("1) Display all products");
                System.out.println("2) Display all customers");
                System.out.println("3) Display all categories");
                System.out.println("0) Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) {
                    System.out.println("Exiting the application...");
                    break;
                }

                switch (choice) {
                    case 1:
                        displayAllProducts();
                        break;
                    case 2:
                        displayAllCustomers();
                        break;
                    case 3:
                        displayAllCategories();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeDataSource() {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    private static void displayAllProducts() {
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.println("\nProduct List:");
            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");

                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Unit Price: " + unitPrice);
                System.out.println("Units In Stock: " + unitsInStock);
                System.out.println("-----------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching product data.");
            e.printStackTrace();
        }
    }

    private static void displayAllCustomers() {
        String query = """
            SELECT CompanyName, ContactName, City, Country, Phone
            FROM customers
            ORDER BY Country
            """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.println("\nCustomer List:");
            while (results.next()) {
                String companyName = results.getString("CompanyName");
                String contactName = results.getString("ContactName");
                String city = results.getString("City");
                String country = results.getString("Country");
                String phone = results.getString("Phone");

                System.out.printf("Company Name: %s | Contact Name: %s | City: %s | Country: %s | Phone: %s%n",
                        companyName, contactName, city, country, phone);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching customer data.");
            e.printStackTrace();
        }
    }

    private static void displayAllCategories() {
        String queryCategories = """
            SELECT CategoryID, CategoryName
            FROM categories
            ORDER BY CategoryID
            """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statementCategories = connection.prepareStatement(queryCategories);
             ResultSet resultsCategories = statementCategories.executeQuery()) {

            System.out.println("\nCategories List:");
            while (resultsCategories.next()) {
                int categoryId = resultsCategories.getInt("CategoryID");
                String categoryName = resultsCategories.getString("CategoryName");

                System.out.printf("Category ID: %d | Category Name: %s%n", categoryId, categoryName);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter a Category ID to display all products in that category: ");
            int selectedCategoryId = scanner.nextInt();

            String queryProducts = """
                SELECT ProductID, ProductName, UnitPrice, UnitsInStock
                FROM products
                WHERE CategoryID = ?
                ORDER BY ProductName
                """;
            try (PreparedStatement statementProducts = connection.prepareStatement(queryProducts)) {
                statementProducts.setInt(1, selectedCategoryId);

                try (ResultSet resultsProducts = statementProducts.executeQuery()) {
                    System.out.println("\nProducts in the selected category:");
                    if (resultsProducts.next()) {
                        do {
                            int productId = resultsProducts.getInt("ProductID");
                            String productName = resultsProducts.getString("ProductName");
                            double unitPrice = resultsProducts.getDouble("UnitPrice");
                            int unitsInStock = resultsProducts.getInt("UnitsInStock");

                            System.out.printf("Product ID: %d | Product Name: %s | Unit Price: %.2f | Units In Stock: %d%n",
                                    productId, productName, unitPrice, unitsInStock);
                        } while (resultsProducts.next());
                    } else {
                        System.out.println("No products found for the selected category.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching data.");
            e.printStackTrace();
        }
    }
}
