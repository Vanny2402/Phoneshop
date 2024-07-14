package com.test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.test.dto.ProductDTO;
import com.test.entity.Model;
import com.test.entity.Product;
import com.test.service.ColorService;
import com.test.service.ModelService;
import com.test.service.ProductService;

@Mapper(componentModel = "spring", uses = { ModelService.class,ColorService.class})
public interface ProductMapper {

	@Mapping(target = "model", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Product toProduct(ProductDTO productDTO);

}
