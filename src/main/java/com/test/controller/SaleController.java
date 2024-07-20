package com.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.SaleDTO;
import com.test.service.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("sales")
public class SaleController {

	private final SaleService saleService;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody SaleDTO saleDTO){
		saleService.sall(saleDTO);
		return ResponseEntity.ok().build();
	}
	
	
}
