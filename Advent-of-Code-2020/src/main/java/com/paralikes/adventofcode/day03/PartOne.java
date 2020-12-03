package com.paralikes.adventofcode.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartOne implements IChallenge<FileInput, Long> {


	@Override
	public Long solve(FileInput input) throws ChallengeException {
		Path inputfile = Paths.get(input.getPath());
		
		try (Stream<String> inputlines = Files.lines(inputfile)) {
			return calculate(inputlines);
		} catch (IOException e) {
			throw new ChallengeException(e);
		}
	}
	
	
	public long calculate(Stream<String> inputlines) throws ChallengeException {
		int[][] map = parseMap(inputlines);
		return countTrees(map, 3, 1);
	}
	
	
	protected int[][] parseMap(Stream<String> inputlines) {
		return inputlines.map(l -> l.chars().toArray()).toArray(int[][]::new);
	}
	
	protected long countTrees(int[][] map, int slopeX, int slopeY) {
		var treesHit = 0;
		for(int y = 0, x = 0; y < map.length;) {
			// The initial position will also be checked
			if(isObstructed(map[y][x])) {
				treesHit++;
			}
			
			x = (x + slopeX) % map[y].length;
			y += slopeY;
		}
		
		return treesHit;
	}
	
	protected boolean isObstructed(int value) {
		return value == '#';
	}
	
}
