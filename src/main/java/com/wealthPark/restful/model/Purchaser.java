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
public class Purchaser {

    public Purchaser(String name) {
        this.name = name;
        this.createdDate = new Date();
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Date createdDate;

    @OneToMany(targetEntity = PurchaserProduct.class, mappedBy = "purchaserId")
//    @JoinColumn(name = "purchaserId" )
    private List<PurchaserProduct> purchaserProduct;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
