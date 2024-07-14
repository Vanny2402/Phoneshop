package com.test.serviceimpl;

import org.springframework.stereotype.Service;

import com.test.entity.Color;
import com.test.exception.ResourceNotFoundException;
import com.test.repository.ColorRepository;
import com.test.service.ColorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServicempl implements ColorService {

	private final ColorRepository colorRepository;

	@Override
	public Color getById(Long id) {
		return colorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Color", id));

	}

	@Override
	public Color create(Color color) {
		return null;
	}

}
