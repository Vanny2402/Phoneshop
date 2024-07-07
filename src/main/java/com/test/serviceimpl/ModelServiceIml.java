package com.test.serviceimpl;



import java.util.List;

import org.springframework.stereotype.Service;

import com.test.dto.ModelDTO;
import com.test.entity.Model;
import com.test.mapper.ModelEnitityMapper;
import com.test.repository.ModelRepository;
import com.test.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceIml implements ModelService {

	private final ModelRepository modelRepository;
	private final ModelEnitityMapper modelMapper;
	@Override
	public Model save(Model model) {		
		return modelRepository.save(model);
	}
	@Override
	public List<Model> getByBrandId(Integer id) {
		return modelRepository.findByBrandId(id);
	}


	
}
