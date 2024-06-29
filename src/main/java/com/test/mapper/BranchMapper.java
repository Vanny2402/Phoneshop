package com.test.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.test.dto.BrandDTO;
import com.test.entity.Brand;

@Mapper

public interface BranchMapper {
//	@Mapping(target = "version", source = "vs")
	BranchMapper INSTANCE =Mappers.getMapper(BranchMapper.class);
	Brand toBrand(BrandDTO dto);

	BrandDTO toBrandDTO(Brand brand);
	List<BrandDTO> toBrandDTOs(List<Brand> brands);
}
