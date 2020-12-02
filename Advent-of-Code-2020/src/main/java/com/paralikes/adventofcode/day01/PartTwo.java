package com.paralikes.adventofcode.day01;

import java.util.Optional;
import java.util.stream.IntStream;

import com.paralikes.adventofcode.ChallengeException;

class PartTwo extends PartOne {

	
	@Override
	public int calculate(IntStream inputNumbers) throws ChallengeException {
		int[] values = inputNumbers.toArray();
		
		Optional<Integer> match = findMatch(values, 2020, 3);
		if(match.isEmpty()) {
			throw new ChallengeException("No solution found");	
		}
		
		return match.get();
	}
	
}
