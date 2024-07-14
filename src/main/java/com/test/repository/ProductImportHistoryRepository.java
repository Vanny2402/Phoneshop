package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.ProductImportHistory;

public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory, Long> {

	 
}
