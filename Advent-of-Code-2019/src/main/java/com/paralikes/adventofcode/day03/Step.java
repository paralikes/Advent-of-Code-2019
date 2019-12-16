package com.paralikes.adventofcode.day03;

class Step {


	private final Direction direction;
	private final int distance;

	public Step(Direction direction, int distance) {
		this.direction = direction;
		this.distance = distance;
	}

	
	public Direction getDirection() {
		return direction;
	}

	public int getDistance() {
		return distance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + distance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Step)) {
			return false;
		}
		Step other = (Step) obj;
		if (direction != other.direction) {
			return false;
		}
		if (distance != other.distance) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Step %d %s", distance, direction);
	}
	
}
