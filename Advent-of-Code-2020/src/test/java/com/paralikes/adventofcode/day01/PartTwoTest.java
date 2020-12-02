package com.paralikes.adventofcode.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.ChallengeTest;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartTwoTest extends ChallengeTest<FileInput, Integer> {


	@Override
	public IChallenge<FileInput, Integer> getChallenge() {
		return new PartTwo();
	}

	@Override
	public FileInput getInput() {
		return new FileInput("./src/test/resources/Day01/input.txt");
	}

	@Override
	public Integer getOutput() {
		return 67877784;
	}

	
	@Override
	public void testRequirements() throws ChallengeException {
		PartTwo challenge = new PartTwo();
		
		assertEquals(241861950, challenge.calculate(Arrays.stream(new int[] { 1721, 979, 366, 299, 675, 1456 })));
	}

}
