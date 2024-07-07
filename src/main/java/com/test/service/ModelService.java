package com.test.service;


import java.util.List;

import com.test.entity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrandId(Integer id);
	
}
