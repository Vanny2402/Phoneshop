package com.test.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductImportDTO {

	@NotNull(message = "The product Can not be null")
	private Long productId;
	@Min(value = 1,message = "Import unit must be greater than 0")
	private Integer importUnit;
	@DecimalMin(value="0.00001",message = "Price must be greater than 0")
	private BigDecimal importPrice;
	@NotNull(message = "Import message can not be null")
	private LocalDate importDate;
	
}
