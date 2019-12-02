package com.paralikes.adventofcode.day02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

class PartOne implements Function<String, Integer> {


	public static final int TERMINATE_OPCODE = 99;
	
	@Override
	public Integer apply(String inputpath) {
		Path inputfile = Paths.get(inputpath);

		try {
			String contents = new String(Files.readAllBytes(inputfile), StandardCharsets.UTF_8);
			String[] textValues = contents.trim().split(",");

			IntStream values = Arrays.stream(textValues).mapToInt(Integer::parseInt);
			return calculate(values, 12, 2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int calculate(IntStream values, int positionOneValue, int positionTwoValue) {
		int[] programMemory = values.toArray();
		programMemory[1] = positionOneValue;
		programMemory[2] = positionTwoValue;

		Map<Integer, OpCode> intStructionSet = new HashMap<>();
		intStructionSet.put(1, (firstInput, secondInput) -> firstInput + secondInput);
		intStructionSet.put(2, (firstInput, secondInput) -> firstInput * secondInput);

		IntcodeProgram intcodeProgram = new IntcodeProgram(programMemory, intStructionSet, TERMINATE_OPCODE);
		intcodeProgram.run();
		
		int result = programMemory[0];
		return result;
	}
	
}
