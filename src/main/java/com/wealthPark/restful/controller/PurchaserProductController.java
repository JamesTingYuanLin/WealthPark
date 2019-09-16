package com.wealthPark.restful.controller;

import com.wealthPark.restful.format.request.PurchaserProductParams;
import com.wealthPark.restful.model.PurchaserProduct;
import com.wealthPark.restful.repository.PurchaserProductRepository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
//        tmp.get(0).getPurchaser().getName();
        Map m = formatResult(tmp, startDate, endDate);
        return m;
    }

    private Map formatResult(List<PurchaserProduct> list, Date start, Date end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Map<String, List<String>>> result = new HashMap<String, Map<String, List<String>>>();
        if (list.size() > 0) {
            Map<String, List<String>> m = new HashMap<String, List<String>>();
            result.put(list.get(0).getPurchaserId().toString(), m);
            for (PurchaserProduct p : list) {
                if (p.getCreatedDate().getTime() < start.getTime() || p.getCreatedDate().getTime() > end.getTime()) continue; // filter out the records out of range.
                Map<String, List<String>> tmp = result.get(list.get(0).getPurchaserId().toString());
                if (tmp.get(sdf.format(p.getCreatedDate())) == null) {
                    List l = new ArrayList<String>();
                    l.add(p.getProductId());
                    tmp.put(sdf.format(p.getCreatedDate()), l);
                } else {
                    List l = tmp.get(sdf.format(p.getCreatedDate()));
                    l.add(p.getProductId());
                    tmp.put(sdf.format(p.getCreatedDate()), l);
                }
            }
        }
        return result;
    }

    private class PurchaserProductResponse {
        public PurchaserProductResponse(Integer purchaserId, Date createdDate, Integer productId) {
            this.purchaserId = purchaserId;
            this.productId = productId;
            this.createdDate = new Date();
            this.deleted = 0;
            this.lastModified = new Date();
        }

        @Id
        @GeneratedValue
        private Integer id;

        private Integer purchaserId;
        private Integer productId;
        private Date createdDate;
        private Integer deleted;
        private Date lastModified;

        public Integer getPurchaserId() {
            return purchaserId;
        }

        public void setPurchaserId(Integer purchaserId) {
            this.purchaserId = purchaserId;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }
    }
}
