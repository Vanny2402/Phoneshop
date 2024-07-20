package com.test.service;

import java.math.BigDecimal;

import com.test.dto.ProductImportDTO;
import com.test.entity.Product;

public interface ProductService {

		Product create(Product product);
		Product getById(Long id);
		void importProduct(ProductImportDTO importDTO);
		
		void setSalePrice(Long productId, BigDecimal price);
		void validateStock(Long productId, Integer numberOfUnit);
		
}
