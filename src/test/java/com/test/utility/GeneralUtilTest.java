package com.test.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralUtilTest {

	@Test
	public void testToIntegerList(){
		//Given
		List<String> names=List.of("Dara","Thida","Seyha");
		//When
		List<Integer> list = GeneralUtil.toIntegerList(names);
		//Then
		//[4,5,5];
		assertEquals(3, list.size());
		assertEquals(4, list.get(0));
		assertEquals(5, list.get(1));
		assertEquals(5, list.get(2));
	}
	
	@Test
	public void testGetEvenNumber() {
		//Given
		List<Integer> list=List.of(2,4,6,8,10,5);
		//When
		List<Integer> evenNumber = GeneralUtil.getEvenNumber(list);
		//Then
		assertEquals(5,evenNumber.size());
		assertEquals(2, list.get(0));

		
		
	}
}
