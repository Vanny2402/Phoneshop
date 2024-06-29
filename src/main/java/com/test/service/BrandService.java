package com.test.service;

import java.util.List;

import com.test.entity.Brand;

public interface BrandService  {
	Brand create(Brand brand);
	Brand getById(int id);
	Brand update(int id, Brand brandUpdate);
	
	List<Brand> getAllBrn();
	
}
