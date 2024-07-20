package com.test.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.dto.ProductSoldDTO;
import com.test.dto.SaleDTO;
import com.test.entity.Product;
import com.test.entity.Sale;
import com.test.entity.SaleDetail;
import com.test.exception.ApiExeption;
import com.test.repository.ProductRepository;
import com.test.repository.SaleDetailRepository;
import com.test.repository.SaleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleServicempl implements SaleService {

	private final ProductService productService;
	private final ProductRepository productRepository;
	private final SaleRepository saleRepository;
	private final SaleDetailRepository saleDetailRepository;

	@Override
	public void sall(SaleDTO saleDTO) {
		// Validation
		// validate(saleDTO);
		// Save

		// product validation
		List<Long> productIds = saleDTO.getProducts().stream().map(ProductSoldDTO::getProductId).toList();

		productIds.forEach(productId -> {
			productService.getById(productId);
		});
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
				.collect(Collectors.toMap(Product::getId, Function.identity()));

		// stock validation
		saleDTO.getProducts().forEach(ps -> {
			Product product = productMap.get(ps.getProductId());
			if (product.getAvaliableUnit() < ps.getNumberOfUnit()) {
				throw new ApiExeption(HttpStatus.BAD_REQUEST,
						"Product name:[%s] does not enugh".formatted(product.getName()));
			}
		});
		
		//Sale
		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);
		

		//Sale Details
		saleDTO.getProducts().forEach(ps -> {
			Product product = productMap.get(ps.getProductId());
			SaleDetail saleDetail = new SaleDetail();
			saleDetail.setAmount(product.getSalePrice());
			saleDetail.setProduct(product);
			saleDetail.setSale(sale);
			saleDetail.setUnit(ps.getNumberOfUnit());
			saleDetailRepository.save(saleDetail);
			
			//Stock deduction
			Integer avaliableUnit= product.getAvaliableUnit()-ps.getNumberOfUnit();
			product.setAvaliableUnit(avaliableUnit);
			productRepository.save(product);
		});
	}

	private void saveSale(SaleDTO saleDTO) {

		Sale sale = new Sale();
		sale.setSoldDate(saleDTO.getSaleDate());
		saleRepository.save(sale);

	}
	private void validate(SaleDTO saleDTO) {
		// product validation
		saleDTO.getProducts().forEach(ps -> {
			Product product = productService.getById(ps.getProductId());
			if (product.getAvaliableUnit() < ps.getNumberOfUnit()) {
				throw new ApiExeption(HttpStatus.BAD_REQUEST,
						"Product name: [%s] does not enugh".formatted(product.getName()));
			}

		});
	}
}
