package com.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.test.dto.ModelDTO;
import com.test.entity.Brand;
import com.test.entity.Model;
import com.test.service.BrandService;

@Mapper(uses = {BrandService.class},componentModel = "spring")
public interface ModelMapper {

	ModelMapper INSTANCE=Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target = "brand",source ="brandId")
	Model toModel(ModelDTO dto);
	
	@Mapping(target = "brandId",source = "model.id")
	ModelDTO toModelDTO(Model model);
	
//	default Brand toBrand(Integer brnId) {
//		Brand brand =new Brand();
//		brand.setId(brnId);
//		return brand;
//	}
}
