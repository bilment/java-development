package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan okuma dosyasını al
        System.out.print("Enter the name of the employee file to process: ");
        String inputFile = scanner.nextLine();

        // Kullanıcıdan çıktı dosyasını al
        System.out.print("Enter the name of the payroll file to create: ");
        String outputFile = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;

            // Eğer çıktı dosyası .csv ise
            if (outputFile.endsWith(".csv")) {
                writeToCSV(br, outputFile);
            }
            // Eğer çıktı dosyası .json ise
            else if (outputFile.endsWith(".json")) {
                writeToJSON(br, outputFile);
            } else {
                System.out.println("Invalid file extension. Please use .csv or .json.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    // CSV formatında yazma
    private static void writeToCSV(BufferedReader br, String outputFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("id|name|gross pay"); // CSV formatında başlık satırı

            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                writer.printf("%d|%s|%.2f%n", employee.getEmployeeID(), employee.getName(), employee.getGrossPay());
            }
        }
    }

    // JSON formatında yazma
    private static void writeToJSON(BufferedReader br, String outputFile) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("["); // JSON array başlat
            String line;
            boolean firstEntry = true;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                // JSON formatında yazma
                if (!firstEntry) {
                    writer.println(",");
                }
                writer.printf("{ \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f }",
                        employee.getEmployeeID(), employee.getName(), employee.getGrossPay());

                firstEntry = false;
            }
            writer.println("\n]");
        }
    }
}

