package com.wealthPark.restful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    public Product(String name) {
        this.name = name;
        this.createdDate = new Date();
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Date createdDate;

    @OneToMany(targetEntity = PurchaserProduct.class, mappedBy = "productId")
//    @JoinColumn(name = "productId")
    private List<PurchaserProduct> purchaserProduct;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
