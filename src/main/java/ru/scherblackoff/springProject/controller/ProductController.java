package ru.scherblackoff.springProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.scherblackoff.springProject.models.Product;
import ru.scherblackoff.springProject.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("products", productService.getAll());
        return "products/show";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.get(id));
        return "products/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product){
        productService.saveOrUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("product", productService.get(id));
        return "products/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product modifiedProduct){
        productService.saveOrUpdate(modifiedProduct);
        return "redirect:/products";
    }

    @GetMapping("/sort/max")
    public String sortByMaxPrice(Model model, @PathVariable("maxPrice") Long maxPrice){
        model.addAttribute("products", productService.findByMaxPrice(maxPrice));
        return "products/show";
    }

    @GetMapping("/sort/min")
    public String sortByMinPrice(Model model, @PathVariable("maxPrice") Long maxPrice){
        model.addAttribute("products", productService.findByMaxPrice(maxPrice));
        return "products/show";
    }

    @GetMapping("/sort/asc")
    public String sortAsc(Model model){
        model.addAttribute("products", productService.findByOrderByPriceAsc());
        return "products/show";
    }

    @GetMapping("/sort/desc")
    public String sortDesc(Model model){
        model.addAttribute("products", productService.findByOrderByPriceDesc());
        return "products/show";
    }
}
