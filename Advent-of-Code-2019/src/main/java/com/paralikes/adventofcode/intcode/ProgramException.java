package com.paralikes.adventofcode.intcode;

public class ProgramException extends RuntimeException {


	private static final long serialVersionUID = -6068151450823680971L;

	public ProgramException() {
		super();
	}
	
	public ProgramException(String message) {
		super(message);
	}
	
	public ProgramException(Throwable cause) {
		super(cause);
	}

	public ProgramException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ProgramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
