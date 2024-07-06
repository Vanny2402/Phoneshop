package com.test.serviceimpl;



import org.springframework.stereotype.Service;

import com.test.entity.Model;
import com.test.mapper.ModelMapper;
import com.test.repository.ModelRepository;
import com.test.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceIml implements ModelService {

	private final ModelRepository modelRepository;
	private final ModelMapper modelMapper;
	@Override
	public Model save(Model model) {		
		return modelRepository.save(model);
	}


	
}
