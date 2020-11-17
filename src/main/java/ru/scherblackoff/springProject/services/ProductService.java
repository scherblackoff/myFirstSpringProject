package ru.scherblackoff.springProject.services;

import ru.scherblackoff.springProject.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product get(Long id);

    Product saveOrUpdate(Product product);

    List<Product> findByMinPrice(Long minPrice);

    List<Product> findByMaxPrice(Long maxPrice);

    Product remove(Product product);

    List<Product> findByOrderByPriceAsc();

    List<Product> findByOrderByPriceDesc();
}
