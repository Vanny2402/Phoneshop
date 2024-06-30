package com.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.BrandDTO;
import com.test.dto.PageDTO;
import com.test.entity.Brand;
import com.test.mapper.BranchMapper;
import com.test.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = BranchMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(brand);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllBrands(@RequestParam Map<String, String> parrams) {
		Page<Brand> allBrn = brandService.getAllBrn(parrams);
		
		PageDTO pageDTO=new PageDTO(allBrn);
//		List<BrandDTO> list = brandService.getAllBrn(parrams).stream()
//				.map(brand -> BranchMapper.INSTANCE.toBrandDTO(brand)).collect(Collectors.toList());
//		return ResponseEntity.ok(list);
		return ResponseEntity.ok(pageDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BranchMapper.INSTANCE.toBrandDTO(brand));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO) {
		Brand brand = BranchMapper.INSTANCE.toBrand(brandDTO);
		Brand updatedBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(BranchMapper.INSTANCE.toBrandDTO(updatedBrand));
	}
}
