package com.paralikes.adventofcode.intcode;

public interface IIntStruction {


	public void execute(IIntcodeProgram program, int instructionPointer, int opcode);

}
