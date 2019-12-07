package com.paralikes.adventofcode.intcode;

import java.util.Map;

public class IntcodeProgram implements IIntcodeProgram {


	private boolean halted = false;
	private int instructionPointer = 0;
	
	private final int[] memory;
	private final Map<Integer, IIntStruction> intStructionSet;

	public IntcodeProgram(int[] memory, Map<Integer, IIntStruction> instructionSet) {
		this.memory = memory;
		this.intStructionSet = instructionSet;
	}
	
	
	@Override
	public void run() {
		this.halted = false;
		this.instructionPointer = 0;
		
		while(!halted) {
			int ip = getInstructionPointer();
			int opcode = getMemoryValue(ip);
			
			IIntStruction instruction = intStructionSet.get(opcode);
			if(instruction == null) {
				throw new ProgramException("Unknown opcode: " + opcode);
			}
			
			instruction.execute(this, ip, opcode);
			
			
			setInstructionPointer(getInstructionPointer() + 4);
		}
	}

	@Override
	public void halt() {
		this.halted = true;
	}


	@Override
	public int getInstructionPointer() {
		return instructionPointer;
	}

	@Override
	public int getMemoryValue(int address) {
		if(address >= memory.length) {
			throw new ProgramException("Invalid address: " + address);
		}
		
		return memory[address];
	}

	@Override
	public int[] getMemory() {
		return memory;
	}

	@Override
	public void setInstructionPointer(int value) {
		if(value < 0) {
			throw new ProgramException("Invalid value for instruction pointer: " + value);
		}
		
		this.instructionPointer = value;
	}

	@Override
	public void setMemoryValue(int address, int value) {
		if(address >= memory.length) {
			throw new ProgramException("Invalid address: " + address);
		}
		
		memory[address] = value;
	}
	
}
