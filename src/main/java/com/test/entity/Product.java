package com.test.entity;

import java.math.BigDecimal;

import org.hibernate.annotations.JoinColumnOrFormula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

@Entity
@Data
@Table(name = "products",uniqueConstraints = {@UniqueConstraint(columnNames = {"model_id","color_id"})})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	
	@Column(name = "product_name",unique = true)
	private String name;

	
	@Column(name = "image_path")
	private String imagPath;
	
	@Column(name="avaliable_unit")
	private Integer avaliableUnit;
	
	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
	
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@DecimalMin(value = "0.000001",message = "Price must be greatter tha 0")
	@Column(name="sale_price")
	private BigDecimal salePrice;
	
	
	
}
