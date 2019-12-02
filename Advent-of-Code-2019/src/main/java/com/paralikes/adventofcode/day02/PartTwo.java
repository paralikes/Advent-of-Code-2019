package com.paralikes.adventofcode.day02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartTwo extends PartOne {


	@Override
	public int calculate(IntStream values, int positionOneValue, int positionTwoValue) {
		List<Integer> originalValues = values.boxed().collect(Collectors.toList());
		for(int i = 0; i < 100; i++) {
			for(int k = 0; k < 100; k++) {
				if(super.calculate(originalValues.stream().mapToInt(Integer::intValue), i, k) == 19690720) {
					return 100 * i + k;
				}
			}
		}
		
		throw new RuntimeException("No valid parameters found");
	}
	
}
