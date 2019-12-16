package com.paralikes.adventofcode.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

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
		return new FileInput("./src/test/resources/Day03/input.txt");
	}

	@Override
	public Integer getOutput() {
		return 3454;
	}

	@Override
	public void testRequirements() throws ChallengeException {
		PartTwo challenge = new PartTwo();
		
		
		ArrayList<Stream<String>> wireDescriptions00 = new ArrayList<>();
		wireDescriptions00.add(Arrays.stream("R8,U5,L5,D3".split(",")));
		wireDescriptions00.add(Arrays.stream("U7,R6,D4,L4".split(",")));
		
		assertEquals(30, challenge.calculate(wireDescriptions00));
		
		ArrayList<Stream<String>> wireDescriptions01 = new ArrayList<>();
		wireDescriptions01.add(Arrays.stream("R75,D30,R83,U83,L12,D49,R71,U7,L72".split(",")));
		wireDescriptions01.add(Arrays.stream("U62,R66,U55,R34,D71,R55,D58,R83".split(",")));
		
		assertEquals(610, challenge.calculate(wireDescriptions01));
		
		
		ArrayList<Stream<String>> wireDescriptions02 = new ArrayList<>();
		wireDescriptions02.add(Arrays.stream("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51".split(",")));
		wireDescriptions02.add(Arrays.stream("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7".split(",")));
		
		assertEquals(410, challenge.calculate(wireDescriptions02));
	}

}
