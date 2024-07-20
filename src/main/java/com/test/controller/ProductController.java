package com.test.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.PriceDTO;
import com.test.dto.ProductDTO;
import com.test.dto.ProductImportDTO;
import com.test.entity.Product;
import com.test.mapper.ProductMapper;
import com.test.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);
		return ResponseEntity.ok(product);
	}

	@PostMapping("/importProduct")
	public ResponseEntity<?>importProduct(@RequestBody @Valid ProductImportDTO importDTO){
		productService.importProduct(importDTO);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("{productId}/setSalePrice")
	public ResponseEntity<?> setSalePrice(@PathVariable Long productId,@RequestBody PriceDTO priceDTO){
		productService.setSalePrice(productId, priceDTO.getPrice());
		return ResponseEntity.ok().build();
	}
}
