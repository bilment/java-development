package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.CustomerOrderHistory;
import com.pluralsight.models.SalesByCategory;
import com.pluralsight.models.SalesByYear;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataManager dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "7991taha?");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Search Customer Order History");
            System.out.println("2. Search Sales by Year");
            System.out.println("3. Search Sales by Category");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Enter a customer ID: ");
                    String customerID = scanner.nextLine();
                    List<CustomerOrderHistory> orderHistoryList = dataManager.searchCustomerOrderHistory(customerID);
                    System.out.println("Customer Order History:");
                    for (CustomerOrderHistory orderHistory : orderHistoryList) {
                        System.out.println("Product Name: " + orderHistory.getProductName()
                                + ", Total Quantity: " + orderHistory.getTotalQuantity());
                    }
                    break;

                case 2:
                    System.out.println("Enter a year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    List<SalesByYear> salesByYearList = dataManager.searchSalesByYear(year);
                    System.out.println("Sales by Year:");
                    for (SalesByYear sales : salesByYearList) {
                        System.out.println("Year: " + sales.getYear()
                                + ", Total Sales: " + sales.getTotalSales());
                    }
                    break;

                case 3:
                    System.out.println("Enter a category name: ");
                    String categoryName = scanner.nextLine();
                    System.out.println("Enter a year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    List<SalesByCategory> salesByCategoryList = dataManager.searchSalesByCategory(categoryName, year);
                    System.out.println("Sales by Category:");
                    for (SalesByCategory sales : salesByCategoryList) {
                        System.out.println("Category: " + sales.getCategoryName()
                                + ", Total Sales: " + sales.getTotalSales());
                    }
                    break;


                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
