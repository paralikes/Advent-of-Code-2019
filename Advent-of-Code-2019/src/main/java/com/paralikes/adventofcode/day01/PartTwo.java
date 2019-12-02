package com.paralikes.adventofcode.day01;

class PartTwo extends PartOne {


	@Override
	public int calculateFuel(int mass) {
		int fuel = super.calculateFuel(mass);
		if(fuel > 0) {
			return fuel + calculateFuel(fuel);
		}
		else {
			return 0;
		}
	}
	
}
