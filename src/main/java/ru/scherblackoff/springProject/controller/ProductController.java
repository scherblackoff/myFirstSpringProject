package ru.scherblackoff.springProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.scherblackoff.springProject.dao.ProductsDAO;
import ru.scherblackoff.springProject.models.Product;

@Controller
@RequestMapping("/products")
public class ProductController {


    private final ProductsDAO productsDAO;

    @Autowired
    public ProductController(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("products", productsDAO.show());
        return "products/show";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productsDAO.getProduct(id));
        return "products/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product){
        productsDAO.save(product);
        return "redirect:/products";
    }
}
