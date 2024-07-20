package com.test.serviceimpl;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.dto.ProductImportDTO;
import com.test.entity.Product;
import com.test.entity.ProductImportHistory;
import com.test.exception.ApiExeption;
import com.test.exception.ResourceNotFoundException;
import com.test.mapper.ProductMapper;
import com.test.repository.ProductImportHistoryRepository;
import com.test.repository.ProductRepository;
import com.test.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServicempl implements ProductService {
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository importHistoryRepository;
	private final ProductMapper productMapper;

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

	@Override
	public void importProduct(ProductImportDTO importDTO) {
		//Update product QTY		
		Product product = getById(importDTO.getProductId());
		Integer avalaibleUnit=0;
		if(product.getAvaliableUnit()!=null) {
			avalaibleUnit=product.getAvaliableUnit();
		}
		product.setAvaliableUnit(avalaibleUnit+importDTO.getImportUnit());
		productRepository.save(product);
		
		//Save product importHisotry	
		ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
		importHistoryRepository.save(importHistory);
	}

	@Override
	public void setSalePrice(Long productId, BigDecimal price) {

		 Product product= getById(productId);
		 product.setSalePrice(price);
		 productRepository.save(product);
	}

	@Override
	public void validateStock(Long productId, Integer numberOfUnit) {

		
	}

}
