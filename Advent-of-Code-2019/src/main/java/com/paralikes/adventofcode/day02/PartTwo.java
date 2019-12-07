package com.paralikes.adventofcode.day02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.paralikes.adventofcode.ChallengeException;

class PartTwo extends PartOne {


	private static final int TARGET_OUTPUT = 19690720;
	
	
	@Override
	public int calculate(IntStream values, int noun, int verb) throws ChallengeException {
		return findInputValueForOutput(values, TARGET_OUTPUT);
	}

	public int findInputValueForOutput(IntStream values, int targetOutput) throws ChallengeException {
		List<Integer> originalValues = values.boxed().collect(Collectors.toList());
		
		for(int n = 0; n < 100; n++) {
			for(int v = 0; v < 100; v++) {
				if(super.calculate(originalValues.stream().mapToInt(Integer::intValue), n, v) == targetOutput) {
					return 100 * n + v;
				}
			}
		}
		
		throw new ChallengeException("No input value found for output: " + targetOutput);
	}
	
}
