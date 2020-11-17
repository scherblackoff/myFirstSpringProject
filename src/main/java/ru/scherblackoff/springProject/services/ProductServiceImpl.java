package ru.scherblackoff.springProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.scherblackoff.springProject.exceptions.ProductNotFoundException;
import ru.scherblackoff.springProject.models.Product;
import ru.scherblackoff.springProject.repositories.ProductsRepository;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product get(Long id) {
        return productsRepository.findById(id).orElseThrow((
        )  -> new ProductNotFoundException("Can't found student with id = " + id));
    }

    @Override
    @Transactional
    public Product saveOrUpdate(Product product) {
       return productsRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findByMinPrice(Long minPrice){
        return productsRepository.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findByMaxPrice(Long maxPrice) {
        return productsRepository.findAllByPriceLessThan(maxPrice);
    }

    @Override
    @Transactional
    public Product remove(Product product) {
        productsRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> findByOrderByPriceAsc() {
        return productsRepository.findByOrderByPriceAsc();
    }

    @Override
    public List<Product> findByOrderByPriceDesc() {
        return productsRepository.findByOrderByPriceDesc();
    }
}
