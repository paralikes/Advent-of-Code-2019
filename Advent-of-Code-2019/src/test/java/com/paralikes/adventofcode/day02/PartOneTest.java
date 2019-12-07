package com.paralikes.adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.ChallengeTest;
import com.paralikes.adventofcode.IChallenge;

class PartOneTest extends ChallengeTest<Input, Integer> {


	@Override
	public IChallenge<Input, Integer> getChallenge() {
		return new PartOne();
	}

	@Override
	public Input getInput() {
		return new Input("./src/test/resources/Day02/input.txt", 12, 2);
	}

	@Override
	public Integer getOutput() {
		return 7594646;
	}

	@Override
	public void testRequirements() throws ChallengeException {
		PartOne challenge = new PartOne();
		
		assertEquals(2, challenge.calculate(Arrays.stream(new int[] { 1,0,0,0,99 }), 0, 0));
		assertEquals(2, challenge.calculate(Arrays.stream(new int[] { 2,3,0,3,99 }), 3, 0));

		assertEquals(2, challenge.calculate(Arrays.stream(new int[] { 2,4,4,5,99,0 }), 4, 4));
		assertEquals(30, challenge.calculate(Arrays.stream(new int[] { 1,1,1,4,99,5,6,0,99 }), 1, 1));
	}

}
