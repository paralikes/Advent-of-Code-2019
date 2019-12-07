package com.paralikes.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartOne implements IChallenge<FileInput, Integer> {


	@Override
	public Integer solve(FileInput input) throws ChallengeException {
		Path inputfile = Paths.get(input.getPath());
		
		try (Stream<String> inputlines = Files.lines(inputfile)) {
			return calculate(inputlines);
		} catch (IOException e) {
			throw new ChallengeException(e);
		}
	}
	
	
	public int calculate(Stream<String> inputlines) {
		int fuelSum = inputlines
				.mapToInt(Integer::valueOf)
				.map(this::calculateFuel)
				.sum();
		
		return fuelSum;
	}
	
	public int calculateFuel(int mass) {
		return mass / 3 - 2;
	}
	
}
