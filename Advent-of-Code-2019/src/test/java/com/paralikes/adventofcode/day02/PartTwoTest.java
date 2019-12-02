package com.paralikes.adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartTwoTest {


	@Test
	void test() {
		assertEquals(3376, new PartTwo().apply("./src/test/resources/Day02/input.txt"));
	}
	
	@Test
	void result() {
		System.out.println(new PartTwo().apply("./src/test/resources/Day02/input.txt"));
	}

}
