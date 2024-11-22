SELECT ProductName
FROM Products
WHERE UnitPrice = (SELECT MAX(UnitPrice) FROM Products);

SELECT o.OrderID, o.ShipName, o.ShipAddress
FROM Orders o
JOIN Shippers s ON o.ShipVia = s.ShipperID
WHERE s.CompanyName = 'Federal Shipping';

SELECT o.OrderID
FROM `Order Details` od
JOIN Orders o ON od.OrderID = o.OrderID
WHERE od.ProductID = (SELECT ProductID FROM Products WHERE ProductName = 'Sasquatch Ale');

SELECT e.FirstName, e.LastName
FROM Employees e
JOIN Orders o ON e.EmployeeID = o.EmployeeID
WHERE o.OrderID = 10266;

SELECT c.CompanyName
FROM Customers c
JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE o.OrderID = 10266;
