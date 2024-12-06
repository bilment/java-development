package com.example.NorthwindTradersSpringBoot2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> products = new ArrayList<>();

    public SimpleProductDao() {
        products.add(new Product(1, "Laptop", "Electronics", 999.99));
        products.add(new Product(2, "Phone", "Electronics", 799.99));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public void delete(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
    }

    @Override
    public void update(Product product) {
        delete(product.getProductId());
        products.add(product);
    }

    @Override
    public Product searchById(int productId) {
        Optional<Product> product = products.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst();
        return product.orElse(null);
    }
}