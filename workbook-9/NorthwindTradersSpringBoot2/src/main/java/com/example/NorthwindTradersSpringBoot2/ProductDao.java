package com.example.NorthwindTradersSpringBoot2;

import java.util.List;

public interface ProductDao {
    void add(Product product);
    List<Product> getAll();
    void delete(int productId);
    void update(Product product);
    Product searchById(int productId);
}