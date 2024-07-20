package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.SaleDetail;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

}
