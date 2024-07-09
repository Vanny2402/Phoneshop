package com.test.controller;

import java.util.List;
import java.util.Map;

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
import com.test.dto.ModelDTO;
import com.test.dto.PageDTO;
import com.test.entity.Brand;
import com.test.entity.Model;
import com.test.mapper.BranchMapper;
import com.test.mapper.ModelEnitityMapper;
import com.test.service.BrandService;
import com.test.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("brands")
public class BrandController {
	private final BrandService brandService;
	private final ModelService modelService;
	private final ModelEnitityMapper modelMapper;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
		Brand brand = BranchMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(brand);
	}

	@GetMapping("")
	public ResponseEntity<?> getAllBrands(@RequestParam Map<String, String> params) {
		Page<Brand> allBrn = brandService.getAllBrn(params);
		PageDTO pageDTO = new PageDTO(allBrn);
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

	@GetMapping("{id}/models")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId) {
		List<Model> brands = modelService.getByBrandId(brandId);
		List<ModelDTO> list = brands.stream().map(model -> modelMapper.toModelDTO(model)).toList();
		return ResponseEntity.ok(list);
	}

}
