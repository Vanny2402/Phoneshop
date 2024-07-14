package com.test.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.entity.Brand;
import com.test.exception.ResourceNotFoundException;
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
		//When
		brandService.create(brand);
		//Then
		verify(brandRepository,times(1)).save(brand);
	}
	
	/*

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
	*/
	@Test
	public void testGetByIdSuccess() {
		//Given
		Brand brand=new Brand();
		brand.setName("APPLE");
		brand.setId(1L);
		//When
		when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));
		Brand brandReturn = brandService.getById(1L);
		//Then 
		assertEquals(1,brandReturn.getId());
		assertEquals("APPLE",brandReturn.getName());		
		
	}
	
	@Test
	public void testGetByIdThrow() {
		//Given
		//When
		when(brandRepository.findById(2L)).thenReturn(Optional.empty());

		assertThatThrownBy(()-> brandService.getById(2L))
		.isInstanceOf(ResourceNotFoundException.class)
		.hasMessage("Brands with id=2 not found").hasMessageEndingWith("not found");
		//Then
	}
	
}
