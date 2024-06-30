package com.test.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.test.entity.Brand;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class BrandSpec implements Specification<Brand> {

	private final BrandFilter brandFilter;
	List<Predicate> predicates=new ArrayList<>();
	
	@Override
	public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder cb) { if(brandFilter.getName()!=null) {
			Predicate pName = cb.like(cb.upper(brand.get("name")),"%"+brandFilter.getName().toUpperCase()+"%");	
			predicates.add(pName);
		}
		
		if(brandFilter.getId() != null) {
			Predicate pId = brand.get("id").in(brandFilter.getId());
			predicates.add(pId);
		} 
		return cb.and(predicates.toArray(new Predicate[0]));
	}

}
