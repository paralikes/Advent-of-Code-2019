package com.paralikes.adventofcode.day02;

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
		return 3376;
	}

	@Override
	public void testRequirements() throws ChallengeException {
		// TODO Auto-generated method stub
	}

}
