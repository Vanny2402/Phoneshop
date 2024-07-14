package com.test.serviceimpl;



import java.util.List;

import org.springframework.stereotype.Service;

import com.test.entity.Model;
import com.test.exception.ResourceNotFoundException;
import com.test.repository.ModelRepository;
import com.test.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceIml implements ModelService {

	private final ModelRepository modelRepository;
	@Override
	public Model save(Model model) {		
		return modelRepository.save(model);
	}
	@Override
	public List<Model> getByBrandId(Long brandId) {
		return modelRepository.findByBrandId(brandId);
	}
	@Override
	public Model getById(Long id) {
		return modelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Model",id));
	}	


	
}
