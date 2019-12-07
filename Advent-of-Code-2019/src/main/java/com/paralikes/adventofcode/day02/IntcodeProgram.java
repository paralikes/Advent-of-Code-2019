package com.paralikes.adventofcode.day02;

import java.util.Map;

import com.paralikes.adventofcode.ChallengeException;

class IntcodeProgram {


	private final int[] memory;
	private final Map<Integer, OpCode> intStructionSet;
	private final int terminateOpcode;

	public IntcodeProgram(int[] memory, Map<Integer, OpCode> intStructionSet, int terminateOpcode) {
		this.memory = memory;
		this.intStructionSet = intStructionSet;
		this.terminateOpcode = terminateOpcode;
	}
	
	
	public void run() throws ChallengeException {
		for(int instructionPointer = 0; instructionPointer < memory.length - 3; instructionPointer += 4) {
			int opcode = memory[instructionPointer];
			int firstInputAddress = memory[instructionPointer + 1];
			int secondInputAddress = memory[instructionPointer + 2];
			int resultAddress = memory[instructionPointer + 3];
			
			int firstInput = memory[firstInputAddress];
			int secondInput = memory[secondInputAddress];
			
			if(opcode == terminateOpcode) {
				break;
			}
			
			OpCode code = intStructionSet.get(opcode);
			if(code == null) {
				throw new ChallengeException("No instruction for opcode: " + opcode);
			}
			
			int result = code.run(firstInput, secondInput);
			memory[resultAddress] = result;
		}
	}
	
}
