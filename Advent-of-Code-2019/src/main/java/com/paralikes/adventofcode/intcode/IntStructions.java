package com.paralikes.adventofcode.intcode;

public class IntStructions {


	private IntStructions() {}
	
	
	public static final IIntStruction ADDITION = new CalculateIntStruction((firstInput, secondInput) -> firstInput + secondInput);
	public static final IIntStruction MULTIPLICATION = new CalculateIntStruction((firstInput, secondInput) -> firstInput * secondInput);
	
	public static final IIntStruction HALT = (program, ip, opcode) -> program.halt();
	
}
