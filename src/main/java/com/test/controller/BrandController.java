package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.BrandDTO;
import com.test.entity.Brand;
import com.test.service.BrandService;
import com.test.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand=Mapper.toBrand(brandDTO);
		brand=brandService.create(brand);
		return ResponseEntity.ok(brand);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable ("id") Integer brandId){
		Brand brand=brandService.getById(brandId);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable ("id") Integer brandId, @RequestBody BrandDTO brandDTO){
		Brand brand=Mapper.toBrand(brandDTO);
		Brand updatedBrand= brandService.update(brandId, brand);	
		return ResponseEntity.ok(Mapper.toBrandDTO(updatedBrand));
	}
}
