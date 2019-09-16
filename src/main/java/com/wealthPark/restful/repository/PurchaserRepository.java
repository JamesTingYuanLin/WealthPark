package com.wealthPark.restful.repository;

import com.wealthPark.restful.model.Purchaser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaserRepository extends JpaRepository<Purchaser, Integer> {
}
