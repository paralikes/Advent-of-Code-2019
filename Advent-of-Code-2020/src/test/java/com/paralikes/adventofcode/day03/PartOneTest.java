package com.paralikes.adventofcode.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.ChallengeTest;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartOneTest extends ChallengeTest<FileInput, Long> {


	@Override
	public IChallenge<FileInput, Long> getChallenge() {
		return new PartOne();
	}
	
	@Override
	public FileInput getInput() {
		return new FileInput("./src/test/resources/Day03/input.txt");
	}
	
	@Override
	public Long getOutput() {
		return 203L;
	}
	
	
	@Override
	public void testRequirements() throws ChallengeException {
		PartOne challenge = new PartOne();
		
		var map = "..##.......\r\n"
				+ "#...#...#..\r\n"
				+ ".#....#..#.\r\n"
				+ "..#.#...#.#\r\n"
				+ ".#...##..#.\r\n"
				+ "..#.##.....\r\n"
				+ ".#.#.#....#\r\n"
				+ ".#........#\r\n"
				+ "#.##...#...\r\n"
				+ "#...##....#\r\n"
				+ ".#..#...#.#";
		
		assertEquals(7, challenge.calculate(map.lines()));
	}
	
}
