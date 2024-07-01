package com.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.entity.Brand;
import com.test.repository.BrandRepository;
import com.test.serviceimpl.BrandServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	
	@Mock
	private BrandRepository brandRepository;
	private BrandService brandService;
	
	@BeforeEach
	public void setUp() {
		brandService=new BrandServiceImpl(brandRepository);
	}

	@Test
	public void testCreate() {
		//Given
		Brand brand =new Brand();
		brand.setName("Apple");
		brand.setId(1);
		//When
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand brandReturn = brandService.create(new Brand());
		//Then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());

	}
}
