package com.paralikes.adventofcode;

public class ChallengeException extends Exception {


	private static final long serialVersionUID = 2294543765848589213L;

	
	public ChallengeException() {
		super();
	}
	
	public ChallengeException(String message) {
		super(message);
	}
	
	public ChallengeException(Throwable cause) {
		super(cause);
	}

	public ChallengeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ChallengeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
