package com.paralikes.adventofcode.day03;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.paralikes.adventofcode.ChallengeException;

class PartTwo extends PartOne {


	@Override
	public int calculate(List<Stream<String>> wireDescriptions) throws ChallengeException {
		List<Wire> wires = parseWires(wireDescriptions);
		Set<Intersection> intersections = calculateIntersections(wires);
		
		Intersection intersection = intersections
			.stream()
			.filter(i -> i.getNumberOfSteps() > 0)
			.min((i1, i2) -> i1.getNumberOfSteps() - i2.getNumberOfSteps())
			.get();
		
		
		int result = intersection.getNumberOfSteps();
		return result;
	}
	
	
	public Set<Intersection> calculateIntersections(List<Wire> wires) {
		Set<Location> intersections = findIntersections(wires);
		
		HashSet<Intersection> result = new HashSet<>();
		for (Location intersection : intersections) {
			int stepSum = 0;
			
			for (Wire wire : wires) {
				int stepCounter = 0;
				for (Location location : wire.getLocations()) {
					if(intersection.equals(location)) {
						break;
					}
					
					stepCounter++;
				}
				
				stepSum += stepCounter;
			}

			result.add(new Intersection(intersection, stepSum));
		}
		
		return result;
	}
	
}
