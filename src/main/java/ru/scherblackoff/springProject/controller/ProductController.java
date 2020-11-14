package ru.scherblackoff.springProject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.scherblackoff.springProject.models.Product;
import ru.scherblackoff.springProject.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService = new ProductService();

    @GetMapping()
    public String index(Model model){
        model.addAttribute("products", productService.findAllProducts());
        return "products/show";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findProduct(id));
        return "products/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
