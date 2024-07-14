package com.test.service;


import java.util.List;

import com.test.entity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrandId(Long id);

	Model getById(Long id);
	
}
