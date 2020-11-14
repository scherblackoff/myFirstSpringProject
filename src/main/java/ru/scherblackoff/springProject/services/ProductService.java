package ru.scherblackoff.springProject.services;

import ru.scherblackoff.springProject.DAO.ProductDAO;
import ru.scherblackoff.springProject.models.Product;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();

    public ProductService() {
    }

    public Product findProduct(int id) {
        return productDAO.findById(id);
    }

    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    public void deleteProduct(Product product) {
        productDAO.delete(product);
    }


    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }
}
