package com.wealthPark.restful.controller;

import com.wealthPark.restful.model.Purchaser;
import com.wealthPark.restful.repository.PurchaserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/purchaser"})
public class PurchaserController {

    private PurchaserRepository repository;

    PurchaserController(PurchaserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @PostMapping (path = {"add/{name}"})
    public void addPurchaser(@PathVariable String name) {
        repository.save(new Purchaser(name));
    }
}
