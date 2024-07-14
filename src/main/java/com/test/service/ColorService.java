package com.test.service;

import com.test.entity.Color;

public interface ColorService {

	Color create(Color color);
	Color getById(Long id);
}
