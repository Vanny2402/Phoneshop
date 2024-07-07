package com.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.ModelDTO;
import com.test.entity.Model;
import com.test.mapper.ModelEnitityMapper;
import com.test.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	

	private final ModelService modelService;
	private final ModelEnitityMapper modelMapper;
	@RequestMapping( method = RequestMethod.POST)//PostMapping
	public ResponseEntity<?> Create(@RequestBody ModelDTO modelDTO){
		Model model =modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(ModelEnitityMapper.INSTANCE.toModelDTO(model));
	}

}
