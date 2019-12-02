package com.paralikes.adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class PartOneTest {


	@Test
	void test() {
		assertEquals(2, new PartOne().calculate(Arrays.stream(new int[] { 1,0,0,0,99 }), 0, 0));
		assertEquals(2, new PartOne().calculate(Arrays.stream(new int[] { 2,3,0,3,99 }), 3, 0));

		assertEquals(2, new PartOne().calculate(Arrays.stream(new int[] { 2,4,4,5,99,0 }), 4, 4));
		assertEquals(30, new PartOne().calculate(Arrays.stream(new int[] { 1,1,1,4,99,5,6,0,99 }), 1, 1));
		
		
		assertEquals(7594646, new PartOne().apply("./src/test/resources/Day02/input.txt"));
	}
	
	@Test
	void result() {
		System.out.println(new PartOne().apply("./src/test/resources/Day02/input.txt"));
	}

}
