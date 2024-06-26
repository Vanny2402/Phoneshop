package com.test.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.embedded.JettyVirtualThreadsWebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.test.entity.Brand;
import com.test.exception.ApiExeption;
import com.test.exception.ResourceNotFoundException;
import com.test.repository.BrandRepository;
import com.test.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(int id) {	
		return brandRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Brands", id));
		}


	@Override
	public Brand update(int id, Brand brandUpdate) {
		
		Brand brand= getById(id);
		brand.setName(brandUpdate.getName()); // @TODO Improve Update
		return brandRepository.save(brand);
		}
	}
