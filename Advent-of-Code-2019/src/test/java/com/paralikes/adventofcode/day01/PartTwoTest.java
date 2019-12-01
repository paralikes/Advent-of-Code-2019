package com.paralikes.adventofcode.day01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartTwoTest {


	@Test
	void test() {
		assertEquals(2, new PartTwo().calculateFuel(14));
		assertEquals(966, new PartTwo().calculateFuel(1969));
		assertEquals(50346, new PartTwo().calculateFuel(100756));
		
		assertEquals(4896902, new PartTwo().apply("./src/test/resources/Day01/input.txt"));
	}
	
	@Test
	void result() {
		System.out.println(new PartTwo().apply("./src/test/resources/Day01/input.txt"));
	}

}
