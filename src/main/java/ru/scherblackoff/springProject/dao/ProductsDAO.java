package ru.scherblackoff.springProject.dao;

import org.springframework.stereotype.Component;
import ru.scherblackoff.springProject.models.Product;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductsDAO {

    private List<Product> productList;
    private static int count;

    {
        productList = new ArrayList<>();

        productList.add(new Product(++count, "Огурец", 75));
        productList.add(new Product(++count, "Апельсин", 50));
        productList.add(new Product(++count, "Помидор", 100));
        productList.add(new Product(++count, "Орехи", 150));
    }

    public List<Product> show(){
        return productList;
    }

    public Product getProduct(int id){
        return productList.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    public void save(Product product){
        product.setId(++count);
        productList.add(product);
    }
}
