package com.pluralsight.models;

public class SalesByCategory {
    private String categoryName;
    private double totalSales;

    public SalesByCategory(String categoryName, double totalSales) {
        this.categoryName = categoryName;
        this.totalSales = totalSales;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getTotalSales() {
        return totalSales;
    }
}
