package com.paralikes.adventofcode.day02;

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
		return new FileInput("./src/test/resources/Day02/input.txt");
	}

	@Override
	public Integer getOutput() {
		return 497;
	}

	
	@Override
	public void testRequirements() throws ChallengeException {
		PartTwo challenge = new PartTwo();
		
		assertEquals(1, challenge.calculate(Arrays.stream(new String[] { "1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc" })));
		
		assertEquals(1, challenge.calculate(Arrays.stream(new String[] { "1-2 a: ab" })));
		assertEquals(1, challenge.calculate(Arrays.stream(new String[] { "1-2 a: ba" })));
		assertEquals(0, challenge.calculate(Arrays.stream(new String[] { "1-2 a: a" })));
		assertEquals(0, challenge.calculate(Arrays.stream(new String[] { "1-2 a: b" })));
		assertEquals(0, challenge.calculate(Arrays.stream(new String[] { "2-1 a: 1" })));
		assertEquals(0, challenge.calculate(Arrays.stream(new String[] { "2-1 a: b" })));
	}

}
