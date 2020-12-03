package com.paralikes.adventofcode.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.ChallengeTest;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartTwoTest extends ChallengeTest<FileInput, Long> {


	@Override
	public IChallenge<FileInput, Long> getChallenge() {
		return new PartTwo();
	}

	@Override
	public FileInput getInput() {
		return new FileInput("./src/test/resources/Day03/input.txt");
	}

	@Override
	public Long getOutput() {
		return 3316272960L;
	}

	
	@Override
	public void testRequirements() throws ChallengeException {
		PartTwo challenge = new PartTwo();
		
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
		
		assertEquals(336, challenge.calculate(map.lines()));
	}

}
