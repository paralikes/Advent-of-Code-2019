package com.paralikes.adventofcode.day03;

class Location {


	private final int x;
	private final int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	public int getManhattanDistance() {
		return Math.abs(x) + Math.abs(y);
	}
	

	public Location step(Step step) {
		int targetX = x;
		int targetY = y;
		
		switch (step.getDirection()) {
		case LEFT:
			targetX -= 1;
			break;
		case UP:
			targetY += 1;
			break;
		case RIGHT:
			targetX += 1;
			break;
		case DOWN:
			targetY -= 1;
			break;
		}
		
		return new Location(targetX, targetY);
	}
	
	public Location move(Step step) {
		int targetX = x;
		int targetY = y;
		
		switch (step.getDirection()) {
		case LEFT:
			targetX -= step.getDistance();
			break;
		case UP:
			targetY += step.getDistance();
			break;
		case RIGHT:
			targetX += step.getDistance();
			break;
		case DOWN:
			targetY -= step.getDistance();
			break;
		}
		
		return new Location(targetX, targetY);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Location)) {
			return false;
		}
		Location other = (Location) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Location (%d, %d)", x, y);
	}
	
}
