package com.paralikes.adventofcode.day02;

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
		// TODO Auto-generated method stub
	}

}
