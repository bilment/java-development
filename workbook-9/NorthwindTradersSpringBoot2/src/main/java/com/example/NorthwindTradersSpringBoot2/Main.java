package com.example.NorthwindTradersSpringBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. List Products");
            System.out.println("2. Add Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Update Product");
            System.out.println("5. Search Product by ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nProduct List:");
                    for (Product product : productDao.getAll()) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();

                    Product newProduct = new Product(id, name, category, price);
                    productDao.add(newProduct);
                    System.out.println("Product added successfully.");
                    break;
                case 3:
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    productDao.delete(deleteId);
                    System.out.println("Product deleted successfully.");
                    break;
                case 4:
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new product category: ");
                    String newCategory = scanner.nextLine();

                    System.out.print("Enter new product price: ");
                    double newPrice = scanner.nextDouble();

                    Product updatedProduct = new Product(updateId, newName, newCategory, newPrice);
                    productDao.update(updatedProduct);
                    System.out.println("Product updated successfully.");
                    break;
                case 5:
                    System.out.print("Enter product ID to search: ");
                    int searchId = scanner.nextInt();
                    Product searchedProduct = productDao.searchById(searchId);
                    if (searchedProduct != null) {
                        System.out.println("Product found: " + searchedProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}