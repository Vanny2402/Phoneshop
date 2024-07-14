package com.test.serviceimpl;

import org.springframework.stereotype.Service;

import com.test.entity.Product;
import com.test.exception.ResourceNotFoundException;
import com.test.repository.ProductRepository;
import com.test.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServicempl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public Product create(Product product) {
		String name="%s %s"
				.formatted(product.getModel().getName(),product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product",id));
	}

}
