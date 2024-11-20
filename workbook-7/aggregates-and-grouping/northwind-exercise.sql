SELECT COUNT(*) AS SupplierCount FROM Suppliers;

SELECT SUM(Salary) AS TotalSalaries FROM Employees;

SELECT MIN(UnitPrice) AS CheapestPrice FROM Products;

SELECT AVG(UnitPrice) AS AveragePrice FROM Products;

SELECT MAX(UnitPrice) AS MostExpensivePrice FROM Products;

SELECT SupplierID, COUNT(*) AS NumberOfItems
FROM Products
GROUP BY SupplierID;

SELECT CategoryID, AVG(UnitPrice) AS AveragePrice
FROM Products
GROUP BY CategoryID;

SELECT CategoryID, AVG(UnitPrice) AS AveragePrice
FROM Products
GROUP BY CategoryID;

SELECT SupplierID, COUNT(*) AS NumberOfItems
FROM Products
GROUP BY SupplierID
HAVING COUNT(*) >= 5;

SELECT ProductID, ProductName, (UnitPrice * UnitsInStock) AS InventoryValue
FROM Products
ORDER BY InventoryValue DESC, ProductName;