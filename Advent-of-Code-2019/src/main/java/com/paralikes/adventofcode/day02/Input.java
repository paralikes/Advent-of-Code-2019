package com.paralikes.adventofcode.day02;

import com.paralikes.adventofcode.FileInput;

class Input extends FileInput {


	private final int noun;
	private final int verb;

	public Input(String path, int noun, int verb) {
		super(path);
		
		this.noun = noun;
		this.verb = verb;
	}
	
	
	public int getNoun() {
		return noun;
	}
	
	public int getVerb() {
		return verb;
	}

}
