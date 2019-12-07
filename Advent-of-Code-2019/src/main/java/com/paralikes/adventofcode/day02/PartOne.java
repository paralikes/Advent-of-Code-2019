package com.paralikes.adventofcode.day02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.IChallenge;
import com.paralikes.adventofcode.intcode.IIntStruction;
import com.paralikes.adventofcode.intcode.IntStructions;
import com.paralikes.adventofcode.intcode.IntcodeProgram;

class PartOne implements IChallenge<Input, Integer> {


	@Override
	public Integer solve(Input input) throws ChallengeException {
		Path inputfile = Paths.get(input.getPath());

		try {
			String contents = new String(Files.readAllBytes(inputfile), StandardCharsets.UTF_8);
			String[] textValues = contents.trim().split(",");

			IntStream values = Arrays.stream(textValues).mapToInt(Integer::parseInt);
			return calculate(values, input.getNoun(), input.getVerb());
		} catch (IOException e) {
			throw new ChallengeException(e);
		}
	}
	
	
	public int calculate(IntStream values, int noun, int verb) throws ChallengeException {
		int[] programMemory = values.toArray();
		programMemory[1] = noun;
		programMemory[2] = verb;

		Map<Integer, IIntStruction> instructionSet = new HashMap<>();
		instructionSet.put(1, IntStructions.ADDITION);
		instructionSet.put(2, IntStructions.MULTIPLICATION);
		instructionSet.put(99, IntStructions.HALT);

		IntcodeProgram intcodeProgram = new IntcodeProgram(programMemory, instructionSet);
		intcodeProgram.run();
		
		int result = programMemory[0];
		return result;
	}
	
}
