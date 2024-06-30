package com.test.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.entity.Brand;
import com.test.exception.ResourceNotFoundException;
import com.test.repository.BrandRepository;
import com.test.service.BrandService;
import com.test.spec.BrandFilter;
import com.test.spec.BrandSpec;
import com.test.util.PageUtil;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brands", id));
	}

	@Override
	public Brand update(Integer id, Brand brandUpdate) {

		Brand brand = getById(id);
		brand.setName(brandUpdate.getName()); // @TODO Improve Update
		return brandRepository.save(brand);
	}
	@Override
	public List<Brand> getAllBrn() {
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getAllBrn(String name) {
		return brandRepository.findByNameContainingIgnoreCase(name);
		
	}
	@Override
	public Page<Brand> getAllBrn(Map<String, String> params) {
		BrandFilter brandFilter= new BrandFilter();
		if(params.containsKey("id")) {
			String id=params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		if(params.containsKey("name")) {
			String name=params.get("name");
			brandFilter.setName(name);
		}
		
		//TODO Will Separate this to Function for pageable
		int pageLimit=PageUtil.DEFAULT_PAGE_LIMINT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit=Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		
		int pageNumber=PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber=Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}

		
		BrandSpec brandSpec=new BrandSpec(brandFilter);
		Pageable pageable= PageUtil.getPageAble(pageNumber, pageLimit);
	    Page<Brand> page = brandRepository.findAll(brandSpec,pageable);
	    return page;

	}
}
