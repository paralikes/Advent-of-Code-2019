package com.paralikes.adventofcode.day03;

import java.util.stream.Stream;

import com.paralikes.adventofcode.ChallengeException;

class PartTwo extends PartOne {

	
	@Override
	public long calculate(Stream<String> inputlines) throws ChallengeException {
		int[][] map = parseMap(inputlines);
		
		return countTrees(map, 1, 1) *
				countTrees(map, 3, 1) *
				countTrees(map, 5, 1) *
				countTrees(map, 7, 1) *
				countTrees(map, 1, 2);
	}
	
}
