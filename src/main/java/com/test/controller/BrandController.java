package com.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
//		Brand brand=Mapper.toBrand(brandDTO);
		Brand brand = BranchMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(brand);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllBrands() {
//		List<Brand> Lbrand=brandService.getAllBrn();
		List<BrandDTO> list = brandService.getAllBrn().stream().map(brand -> BranchMapper.INSTANCE.toBrandDTO(brand))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
//			return ResponseEntity.ok(brandService.getAllBrn());
//			return ResponseEntity.ok(BranchMapper.INSTANCE.toBrandDTOs(Lbrand));
	}

	@GetMapping("filter")
	public ResponseEntity<?> findByName(@RequestParam("name") String name){
		List<BrandDTO> list = brandService.getAllBrn(name)
				.stream()
				.map(brand -> BranchMapper.INSTANCE.toBrandDTO(brand))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BranchMapper.INSTANCE.toBrandDTO(brand));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO) {
//		Brand brand=Mapper.toBrand(brandDTO);
		Brand brand = BranchMapper.INSTANCE.toBrand(brandDTO);
		Brand updatedBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(BranchMapper.INSTANCE.toBrandDTO(updatedBrand));
	}
}
