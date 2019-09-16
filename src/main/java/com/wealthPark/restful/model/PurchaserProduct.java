package com.wealthPark.restful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PurchaserProduct {
    public PurchaserProduct(Integer purchaserId, Integer productId) {
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

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    private Integer deleted;

    private Date lastModified;

    @OneToOne
    @JoinColumn(name = "id")
    private Purchaser purchaser;

    @OneToOne
    @JoinColumn(name = "id")
    private Product product;

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

    public Purchaser getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(Purchaser purchaser) {
        this.purchaser = purchaser;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
