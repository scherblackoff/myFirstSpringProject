package ru.scherblackoff.springProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.scherblackoff.springProject.models.Product;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByPriceGreaterThan(Long minPrice);
    List<Product> findAllByPriceLessThan(Long maxPrice);
    List<Product> findByOrderByPriceAsc();
    List<Product> findByOrderByPriceDesc();
}
