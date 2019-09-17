package com.wealthPark.restful.controller;

import com.wealthPark.restful.format.request.PurchaserProductParams;
import com.wealthPark.restful.model.PurchaserProduct;
import com.wealthPark.restful.repository.PurchaserProductRepository;
import com.wealthPark.restful.utils.OutputFormatter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/purchaser-product"})
public class PurchaserProductController {

    private PurchaserProductRepository repository;

    PurchaserProductController(PurchaserProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @PostMapping (path = {"add"})
    public void addPurchaser(@RequestBody PurchaserProductParams purchaserProduct) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate createdLocalDate = LocalDate.parse(purchaserProduct.getCreatedDate(), formatter);
        Date createdDate = Date.from(createdLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        repository.save(new PurchaserProduct(purchaserProduct.getPurchaserId(), purchaserProduct.getProductId(), createdDate));
    }

    @GetMapping (path = {"/purchaser/{purchaserId}/product"})
    public Map findProductByPurchaserIdByDate(@PathVariable Integer purchaserId, @RequestParam String start_date, @RequestParam String end_date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startLocalDate = LocalDate.parse(start_date, formatter);
        LocalDate endLocalDate = LocalDate.parse(end_date, formatter);
        Date startDate = Date.from(startLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//        return repository.findByPurchaserIdAndCreatedDateBetween(purchaserId, Date.from(startLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        return repository.findByCreatedDateBetween(Date.from(startLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        List<PurchaserProduct> tmp = repository.findByPurchaserId(purchaserId);
        Map m = OutputFormatter.formatResult(tmp, startDate, endDate);
        return m;
    }
}
