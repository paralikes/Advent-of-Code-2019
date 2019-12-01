package com.paralikes.adventofcode.day01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PartOneTest {


	@Test
	void test() {
		assertEquals(2, new PartOne().calculateFuel(12));
		assertEquals(2, new PartOne().calculateFuel(14));
		assertEquals(654, new PartOne().calculateFuel(1969));
		assertEquals(33583, new PartOne().calculateFuel(100756));
		
		assertEquals(3266516, new PartOne().apply("./src/test/resources/Day01/input.txt"));
	}
	
	@Test
	void result() {
		System.out.println(new PartOne().apply("./src/test/resources/Day01/input.txt"));
	}

}
