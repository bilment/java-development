package com.pluralsight.db;

import com.pluralsight.models.CustomerOrderHistory;
import com.pluralsight.models.SalesByCategory;
import com.pluralsight.models.SalesByYear;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public DataManager(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public List<CustomerOrderHistory> searchCustomerOrderHistory(String customerID) {
        List<CustomerOrderHistory> orderHistoryList = new ArrayList<>();
        String query = "{CALL CustOrderHistory(?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {

            callableStatement.setString(1, customerID);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String productName = resultSet.getString("ProductName");
                int totalQuantity = resultSet.getInt("Total");
                orderHistoryList.add(new CustomerOrderHistory(productName, totalQuantity));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    public List<SalesByYear> searchSalesByYear(int year) {
        List<SalesByYear> salesByYearList = new ArrayList<>();
        String query = "{CALL Sales_by_Year(?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {

            callableStatement.setInt(1, year);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                int salesYear = resultSet.getInt("Year");
                double totalSales = resultSet.getDouble("TotalSales");
                salesByYearList.add(new SalesByYear(salesYear, totalSales));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesByYearList;
    }

    public List<SalesByCategory> searchSalesByCategory(String categoryName, int year) {
        List<SalesByCategory> salesByCategoryList = new ArrayList<>();
        String query = "{CALL SalesByCategory(?, ?)}";

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {

            callableStatement.setString(1, categoryName);
            callableStatement.setInt(2, year);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String category = resultSet.getString("CategoryName");
                double totalSales = resultSet.getDouble("TotalSales");
                salesByCategoryList.add(new SalesByCategory(category, totalSales));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesByCategoryList;
    }

}
