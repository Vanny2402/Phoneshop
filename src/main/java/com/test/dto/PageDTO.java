package com.test.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;
@Data
public class PageDTO {
	private List<?> list;
	private PaginationDTO pageination;
	
	public PageDTO(Page<?> page) {
		this.list=page.getContent();
		this.pageination=PaginationDTO.builder()
				.empty(page.isEmpty())
				.first(page.isFirst())
				.last(page.isLast())
				.pageSize(page.getPageable().getPageSize())
				.pageNumber(page.getPageable().getPageNumber()+1)
				.totalPage(page.getTotalPages())
				.totalElements(page.getTotalPages())
				.numberOfElements(page.getNumberOfElements())
				.build();
	}

}
