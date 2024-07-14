package com.test.service;

import com.test.entity.Product;

public interface ProductService {

		Product create(Product product);
		Product getById(Long id);
}
