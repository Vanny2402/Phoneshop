package com.test.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="productImportHistory")
public class ProductImportHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="import_id")
	private Long id;
	
	
	@Column(name="date_import")
	private LocalDateTime dateImport;
	
	@Column(name="import_unit")
	private Integer importUnit;
	
	@Column(name="perice_per_unit")
	private BigDecimal pricePerUnit;
	
	
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product; 	
}
