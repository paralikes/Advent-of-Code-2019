package com.paralikes.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartOne implements IChallenge<FileInput, Integer> {


	@Override
	public Integer solve(FileInput input) throws ChallengeException {
		Path inputfile = Paths.get(input.getPath());
		
		try (Stream<String> inputlines = Files.lines(inputfile)) {
			return calculate(inputlines.mapToInt(Integer::valueOf));
		} catch (IOException e) {
			throw new ChallengeException(e);
		}
	}

	
	public int calculate(IntStream inputNumbers) throws ChallengeException {
		int[] values = inputNumbers.toArray();
		
		Optional<Integer> match = findMatch(values, 2020, 2);
		if(match.isEmpty()) {
			throw new ChallengeException("No solution found");	
		}
		
		return match.get();
	}
	
	
	protected Optional<Integer> findMatch(int[] inputs, int result, int numberOfEntries) {
		if(numberOfEntries <= 2) {
			return Arrays.stream(inputs).mapToObj(a -> Arrays.stream(inputs).filter(b -> a != b && a + b == result).mapToObj(b -> b * a).findFirst().orElse(null))
					.filter(x -> x != null)
					.findFirst();
		}
		else {
			return Arrays.stream(inputs).mapToObj(c -> findMatch(inputs, result - c, numberOfEntries - 1).stream().filter(x -> x != null).map(x -> x * c).findFirst().orElse(null))
					.filter(x -> x != null)
					.findFirst();
		}
	}

}
