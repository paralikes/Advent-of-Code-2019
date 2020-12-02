package com.paralikes.adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

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
		return new FileInput("./src/test/resources/Day02/input.txt");
	}
	
	@Override
	public Integer getOutput() {
		return 528;
	}
	
	
	@Override
	public void testRequirements() throws ChallengeException {
		PartOne challenge = new PartOne();
		
		assertEquals(2, challenge.calculate(Arrays.stream(new String[] { "1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc" })));
	}
	
}
