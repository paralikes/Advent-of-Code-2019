package com.paralikes.adventofcode;

public interface IChallenge<I, O> {


	public O solve(I input) throws ChallengeException;
	
}
