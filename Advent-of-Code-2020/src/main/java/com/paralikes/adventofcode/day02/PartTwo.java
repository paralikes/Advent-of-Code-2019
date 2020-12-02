package com.paralikes.adventofcode.day02;

class PartTwo extends PartOne {

	
	@Override
	protected boolean isValidPassword(PasswordEntry entry) {
		if(entry.getPassword().length() < entry.getPolicyX() || entry.getPassword().length() < entry.getPolicyY()) {
			return false;
		}
		
		boolean xMatches = positionMatches(entry.getPassword(), entry.getPolicyX(), entry.getPolicyValue());
		boolean yMatches = positionMatches(entry.getPassword(), entry.getPolicyY(), entry.getPolicyValue());
		
		return (xMatches || yMatches) && xMatches != yMatches;
	}
	
	
	private boolean positionMatches(String password, int policyPosition, String policyValue) {
		return password.substring(policyPosition - 1, policyPosition - 1 + policyValue.length()).equals(policyValue);
	}
	
}
