package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Model;



public interface ModelRepository extends JpaRepository<Model,Integer> {
	List<Model> findByBrandId(Integer brandId);
	
	
}
