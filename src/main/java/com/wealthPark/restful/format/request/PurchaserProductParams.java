package com.wealthPark.restful.format.request;

public class PurchaserProductParams {

    private Integer purchaserId;

    private Integer productId;

    private String createdDate;

    public PurchaserProductParams() {}

    public PurchaserProductParams(Integer purchaserId, Integer productId, String createdDate) {
        this.purchaserId = purchaserId;
        this.productId = productId;
        this.createdDate = createdDate;
    }

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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
