package com.paralikes.adventofcode.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.ChallengeTest;
import com.paralikes.adventofcode.IChallenge;

class PartTwoTest extends ChallengeTest<Input, Integer> {


	@Override
	public IChallenge<Input, Integer> getChallenge() {
		return new PartTwo();
	}

	@Override
	public Input getInput() {
		return new Input("./src/test/resources/Day02/input.txt", 12, 2);
	}

	@Override
	public Integer getOutput() {
		return 3376;
	}

	
	@Override
	public void testRequirements() throws ChallengeException {
		// Nothing
	}
	
	@Override
	public void verifySolution(IChallenge<Input, Integer> challenge, Input input, Integer output) throws ChallengeException {
		super.verifySolution(challenge, input, output);
		
		assertEquals(19690720, new PartOne().solve(new Input("./src/test/resources/Day02/input.txt", 33, 76))); // Solved with PartOne
	}

}
