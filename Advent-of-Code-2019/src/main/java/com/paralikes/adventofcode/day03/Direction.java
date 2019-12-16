package com.paralikes.adventofcode.day03;

enum Direction {
	LEFT,
	UP,
	RIGHT,
	DOWN;
	
	
	public static Direction parse(char c) {
		switch (c) {
		case 'l':
		case 'L':
			return LEFT;
		case 'u':
		case 'U':
			return UP;
		case 'r':
		case 'R':
			return RIGHT;
		case 'd':
		case 'D':
			return DOWN;
		default:
			throw new IllegalArgumentException("Invalid direction for character: " + c);
		}
	}
	
}
