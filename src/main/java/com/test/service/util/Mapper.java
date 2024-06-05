package com.test.service.util;

import com.test.dto.BrandDTO;
import com.test.entity.Brand;

public class Mapper{

	public static Brand toBrand(BrandDTO dto) {
		Brand brand =new Brand();
//		brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
	
	
	public static BrandDTO toBrandDTO(Brand brand) {
		BrandDTO brandDTO=new BrandDTO();
		brandDTO.setName(brand.getName());
		return brandDTO;
	}
}
