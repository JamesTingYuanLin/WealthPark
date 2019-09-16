package com.wealthPark.restful.repository;

import com.wealthPark.restful.model.PurchaserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PurchaserProductRepository extends JpaRepository<PurchaserProduct, Integer> {
    @Query("select p from PurchaserProduct p where p.id = :purchaserId and p.createdDate between :startDate and :endDate")
    List<PurchaserProduct> findByPurchaserIdAndCreatedDateBetween(Integer purchaserId, Date startDate, Date endDate);

    @Query("select p from PurchaserProduct p where p.createdDate between :startDate and :endDate")
    List<PurchaserProduct> findByCreatedDateBetween(Date startDate, Date endDate);

    List findByPurchaserId(Integer purchaserId);
}
