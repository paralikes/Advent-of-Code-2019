package com.paralikes.adventofcode.day03;

class Intersection {


	private final Location location;
	private final int numberOfSteps;

	public Intersection(Location location, int numberOfSteps) {
		this.location = location;
		this.numberOfSteps = numberOfSteps;
	}

	
	public Location getLocation() {
		return location;
	}

	public int getNumberOfSteps() {
		return numberOfSteps;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + numberOfSteps;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Intersection)) {
			return false;
		}
		Intersection other = (Intersection) obj;
		if (location == null) {
			if (other.location != null) {
				return false;
			}
		} else if (!location.equals(other.location)) {
			return false;
		}
		if (numberOfSteps != other.numberOfSteps) {
			return false;
		}
		return true;
	}

}
