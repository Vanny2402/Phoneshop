package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.ModelDTO;
import com.test.entity.Model;
import com.test.mapper.ModelMapper;
import com.test.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	
	@Autowired
	private final ModelService modelService;
	@RequestMapping( method = RequestMethod.POST)//PostMapping
	public ResponseEntity<?> Create(@RequestBody ModelDTO modelDTO){
		Model model = modelService.save(modelDTO);
		return ResponseEntity.ok(ModelMapper.INSTANCE.toModelDTO(model));
	}

}
