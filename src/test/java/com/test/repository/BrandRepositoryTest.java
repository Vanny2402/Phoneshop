package com.test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.test.entity.Brand;

@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;

	@Test
	public void testFindBynameContainandIgnoreCase() {
		// Given
		Brand brand = new Brand();
		brand.setName("B_Apple");
		Brand brn2=new Brand();
		brn2.setName("Samsung");
		brandRepository.save(brand);
		brandRepository.save(brn2);
		// When
		List<Brand> brands = brandRepository.findByNameContainingIgnoreCase("a");
		// Then
		assertEquals(2, brands.size());
		assertEquals("B_Apple", brands.get(0).getName());
		assertEquals("Samsung", brands.get(1).getName());
		assertEquals(1, brands.get(0).getId());
	}
	
}
