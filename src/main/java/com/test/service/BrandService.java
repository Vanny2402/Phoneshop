package com.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.test.entity.Brand;

public interface BrandService  {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer id, Brand brandUpdate);
	List<Brand> getAllBrn();
	List<Brand> getAllBrn(String name);
	Page<Brand> getAllBrn(Map<String, String> params);

}
