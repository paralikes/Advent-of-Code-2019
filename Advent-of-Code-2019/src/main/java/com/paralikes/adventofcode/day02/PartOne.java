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

class PartOne implements IChallenge<Input, Integer> {


	public static final int TERMINATE_OPCODE = 99;
	
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

		Map<Integer, OpCode> intStructionSet = new HashMap<>();
		intStructionSet.put(1, (firstInput, secondInput) -> firstInput + secondInput);
		intStructionSet.put(2, (firstInput, secondInput) -> firstInput * secondInput);

		IntcodeProgram intcodeProgram = new IntcodeProgram(programMemory, intStructionSet, TERMINATE_OPCODE);
		intcodeProgram.run();
		
		int result = programMemory[0];
		return result;
	}
	
}
