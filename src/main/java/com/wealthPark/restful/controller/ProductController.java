package com.wealthPark.restful.controller;

import com.wealthPark.restful.model.Product;
import com.wealthPark.restful.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/product"})
public class ProductController {

    private ProductRepository repository;

    ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @PostMapping (path = {"add/{name}"})
    public void addPurchaser(@PathVariable String name) {
        repository.save(new Product(name));
    }
}
