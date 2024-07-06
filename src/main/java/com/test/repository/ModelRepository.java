package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Model;


public interface ModelRepository extends JpaRepository<Model,Integer> {

}
