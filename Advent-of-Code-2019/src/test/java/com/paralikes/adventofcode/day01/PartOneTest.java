package com.paralikes.adventofcode.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.ChallengeTest;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartOneTest extends ChallengeTest<FileInput, Integer> {


	@Override
	public IChallenge<FileInput, Integer> getChallenge() {
		return new PartOne();
	}
	
	@Override
	public FileInput getInput() {
		return new FileInput("./src/test/resources/Day01/input.txt");
	}
	
	@Override
	public Integer getOutput() {
		return 3266516;
	}
	
	
	@Override
	public void testRequirements() throws ChallengeException {
		assertEquals(2, new PartOne().calculateFuel(12));
		assertEquals(2, new PartOne().calculateFuel(14));
		assertEquals(654, new PartOne().calculateFuel(1969));
		assertEquals(33583, new PartOne().calculateFuel(100756));
	}
	
}
