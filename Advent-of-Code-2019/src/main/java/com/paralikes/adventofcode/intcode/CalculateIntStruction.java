package com.paralikes.adventofcode.intcode;

public class CalculateIntStruction implements IIntStruction {


	public interface ICalculation {
		
		public int run(int firstInput, int secondInput);
	}

	
	private ICalculation calculation;
	
	public CalculateIntStruction(ICalculation calculation) {
		this.calculation = calculation;
	}
	
	
	@Override
	public void execute(IIntcodeProgram program, int instructionPointer, int opcode) {
		int firstInputAddress = program.getMemoryValue(instructionPointer + 1);
		int secondInputAddress = program.getMemoryValue(instructionPointer + 2);
		int resultAddress = program.getMemoryValue(instructionPointer + 3);
		
		int firstInput = program.getMemoryValue(firstInputAddress);
		int secondInput = program.getMemoryValue(secondInputAddress);
		
		
		int result = calculation.run(firstInput, secondInput);
		
		program.setMemoryValue(resultAddress, result);
	}

}
