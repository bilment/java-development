package com.pluralsight.models;

public class SalesByYear {
    private int year;
    private double totalSales;

    public SalesByYear(int year, double totalSales) {
        this.year = year;
        this.totalSales = totalSales;
    }

    public int getYear() {
        return year;
    }

    public double getTotalSales() {
        return totalSales;
    }
}
