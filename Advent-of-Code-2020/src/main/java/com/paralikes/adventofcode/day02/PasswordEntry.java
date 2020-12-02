package com.paralikes.adventofcode.day02;

public class PasswordEntry {

	
	private final int policyX;
	private final int policyY;
	private final String policyValue;
	private final String password;
	
	public PasswordEntry(int policyX, int policyY, String policyValue, String password) {
		this.policyX = policyX;
		this.policyY = policyY;
		this.policyValue = policyValue;
		this.password = password;
	}

	
	public int getPolicyX() {
		return policyX;
	}

	public int getPolicyY() {
		return policyY;
	}

	public String getPolicyValue() {
		return policyValue;
	}

	public String getPassword() {
		return password;
	}
	
	
	@Override
	public String toString() {
		return String.format("%d-%d %s: %s", policyX, policyY, policyValue, password);
	}
	
}
