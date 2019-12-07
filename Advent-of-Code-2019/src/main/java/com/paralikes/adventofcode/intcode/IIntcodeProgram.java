package com.paralikes.adventofcode.intcode;

public interface IIntcodeProgram {


	public void run();
	
	public void halt();
	
	
	public int getInstructionPointer();
	
	public int getMemoryValue(int address);
	
	public int[] getMemory();

	
	public void setInstructionPointer(int value);
	
	public void setMemoryValue(int address, int value);
	
	//public void setMemory(int[] memory);
	
}
