package com.paralikes.adventofcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public abstract class ChallengeTest<I, O> {


	public abstract IChallenge<I, O> getChallenge();
	
	public abstract I getInput();
	
	public abstract O getOutput();
	
	
	public abstract void testRequirements() throws ChallengeException;
	
	
	public O solve(IChallenge<I, O> challenge, I input) throws ChallengeException {
		return challenge.solve(input);
	}
	
	public void verifySolution(IChallenge<I, O> challenge, I input, O output) throws ChallengeException {
		assertEquals(output, solve(challenge, input));
	}

	
	@Test
	public void testChallenge() throws ChallengeException {
		testRequirements();
	}
	
	@Test
	public void solveChallenge() throws ChallengeException {
		O result = solve(getChallenge(), getInput());
		System.out.println(String.format("The solution for %s is: %s", getClass().getSimpleName().replace("Test", ""), result));
	}
	
	@Test
	public void verifyChallenge() throws ChallengeException {
		verifySolution(getChallenge(), getInput(), getOutput());
	}
	
}
