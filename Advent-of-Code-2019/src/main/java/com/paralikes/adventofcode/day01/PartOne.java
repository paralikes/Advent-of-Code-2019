package com.paralikes.adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

class PartOne implements Function<String, Integer> {


	@Override
	public Integer apply(String inputpath) {
		Path inputfile = Paths.get(inputpath);
		
		try (Stream<String> inputlines = Files.lines(inputfile)) {
			return calculate(inputlines);
		} catch (IOException e) {
			throw new RuntimeException(e);
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
