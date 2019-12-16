package com.paralikes.adventofcode.day03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartOne implements IChallenge<FileInput, Integer> {


	@Override
	public Integer solve(FileInput input) throws ChallengeException {
		Path inputfile = Paths.get(input.getPath());

		try (Stream<String> inputlines = Files.lines(inputfile)) {
			List<Stream<String>> wires = inputlines
					.map((line) -> line.trim().split(","))
					.map(s -> Arrays.stream(s))
					.collect(Collectors.toList());
			
			return calculate(wires);
		} catch (IOException e) {
			throw new ChallengeException(e);
		}
	}
	
	
	public int calculate(List<Stream<String>> wireDescriptions) throws ChallengeException {
		List<Wire> wires = parseWires(wireDescriptions);
		Set<Location> intersections = findIntersections(wires);
		
		HashMap<Location, Integer> locationsToDistances = new HashMap<>(); 
		for (Location location : intersections) {
			locationsToDistances.put(location, location.getManhattanDistance());
		}
		
		Entry<Location, Integer> entry = locationsToDistances
				.entrySet()
				.stream()
				.filter(l -> l.getValue() != 0)
				.min((l1, l2) -> l1.getValue() - l2.getValue())
				.get();

		int result = entry.getValue();
		return result;
	}
	
	
	public Set<Location> findIntersections(List<Wire> wires) {
		HashMap<Location, Integer> locationCount = new HashMap<>();
		
		for (Wire wire : wires) {
			for (Location location : new HashSet<Location>(wire.getLocations())) {
				Integer count = locationCount.getOrDefault(location, 0);
				locationCount.put(location, count + 1);
			}
		}
		
		Set<Location> intersections = locationCount
				.entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.map(e -> e.getKey())
				.collect(Collectors.toSet());
		return intersections;
	}
	
	
	public List<Wire> parseWires(List<Stream<String>> wireDescriptions) throws ChallengeException {
		ArrayList<Wire> wires = new ArrayList<>();
		
		for (Stream<String> stepDescriptions : wireDescriptions) {
			List<Step> steps = parseSteps(stepDescriptions);
			List<Location> locations = followSteps(steps);
			
			wires.add(new Wire(locations));
		}
		
		return wires;
	}
	
	
	public List<Location> followSteps(List<Step> steps) {
		ArrayList<Location> locations = new ArrayList<>();
		
		Location currentLocation = new Location(0, 0);
		locations.add(currentLocation);
		
		for (Step step : steps) {
			Location targetLocation = currentLocation.move(step);
			
			while(!currentLocation.equals(targetLocation)) {
				currentLocation = currentLocation.step(step);
				locations.add(currentLocation);
			}
		}
		
		return locations;
	}
	
	
	public List<Step> parseSteps(Stream<String> stepDescriptions) throws ChallengeException {
		ArrayList<Step> steps = new ArrayList<>();
		
		for (Iterator<String> iterator = stepDescriptions.iterator(); iterator.hasNext();) {
			String step = iterator.next();
			
			Direction direction;
			try {
				direction = Direction.parse(step.charAt(0));
			}
			catch (IllegalArgumentException iae) {
				throw new ChallengeException("Invalid direction for step: " + step);
			}
			
			int distance;
			try {
				distance = Integer.parseInt(step.substring(1));
			}
			catch(NumberFormatException nfe) {
				throw new ChallengeException("Invalid distance for step: " + step);
			}
			
			steps.add(new Step(direction, distance));
		}
		
		return steps;
	}
	

	public void outputWires(List<Wire> wires) throws ChallengeException {
		try {
			File file = File.createTempFile("aoc-", "-day03");
			try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
				printWires(wires, fileOutputStream);
			}
		} catch (IOException e) {
			throw new ChallengeException(e);
		}
	}
	
	
	public void printWires(List<Wire> wires, OutputStream out) throws ChallengeException {
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		
		int xMax = wires.stream().map(w -> (Integer)w.getLocations().stream().mapToInt(l -> l.getX()).max().getAsInt()).mapToInt(Integer::intValue).max().getAsInt() + 1;
		int xMin = wires.stream().map(w -> (Integer)w.getLocations().stream().mapToInt(l -> l.getX()).min().getAsInt()).mapToInt(Integer::intValue).min().getAsInt() + -1;
		int yMax = wires.stream().map(w -> (Integer)w.getLocations().stream().mapToInt(l -> l.getY()).max().getAsInt()).mapToInt(Integer::intValue).max().getAsInt() + 1;
		int yMin = wires.stream().map(w -> (Integer)w.getLocations().stream().mapToInt(l -> l.getY()).min().getAsInt()).mapToInt(Integer::intValue).min().getAsInt() + -1;
		
		System.out.println(String.format("Printing wires on ([%d, %d], [%d, %d] grid", xMin, xMax, yMin, yMax));
		
		try {
			for(int k = yMax; k > yMin; k--) {
				for(int i = xMin; i < xMax; i++) {
					final int x = i;
					final int y = k;
					
					Wire firstWire = wires.get(0);
					Wire secondWire = wires.get(1);
					
					Location currentLocation = new Location(x, y);
					boolean firstWireMatch = firstWire.getLocations().contains(currentLocation);
					boolean secondWireMatch = secondWire.getLocations().contains(currentLocation);
					
					if(x == 0 && y == 0) {
						bufferedWriter.write('O');
					}
					else if(firstWireMatch && secondWireMatch) {
						bufferedWriter.write('X');
					}
					else if(firstWireMatch) {
						bufferedWriter.write('+');
					}
					else if(secondWireMatch) {
						bufferedWriter.write('*');
					}
					else {
						bufferedWriter.write('.');
					}
				}
				
				bufferedWriter.newLine();
			}
			
			bufferedWriter.flush();
		}
		catch (IOException e) {
			throw new ChallengeException(e);
		}
	}

}
