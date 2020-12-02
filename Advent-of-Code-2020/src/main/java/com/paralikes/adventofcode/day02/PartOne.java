package com.paralikes.adventofcode.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import com.paralikes.adventofcode.ChallengeException;
import com.paralikes.adventofcode.FileInput;
import com.paralikes.adventofcode.IChallenge;

class PartOne implements IChallenge<FileInput, Integer> {


	@Override
	public Integer solve(FileInput input) throws ChallengeException {
		Path inputfile = Paths.get(input.getPath());
		
		try (Stream<String> inputlines = Files.lines(inputfile)) {
			return calculate(inputlines);
		} catch (IOException e) {
			throw new ChallengeException(e);
		}
	}
	
	
	public int calculate(Stream<String> inputlines) throws ChallengeException {
		List<PasswordEntry> entries = parseList(inputlines);
		Stream<PasswordEntry> validPasswords = getValidPasswords(entries);
		return (int) validPasswords.count();
	}
	
	protected List<PasswordEntry> parseList(Stream<String> inputlines) throws ChallengeException {
		ArrayList<PasswordEntry> passwordEntries = new ArrayList<>();
		
		for (Iterator<String> iterator = inputlines.iterator(); iterator.hasNext();) {
			String line = iterator.next();
			
			String[] entry = line.trim().split(" ");
			if(entry.length != 3) {
				throw new ChallengeException("Invalid format for entry: " + line);
			}
			
			String[] policyBounds = entry[0].split("-");
			if(policyBounds.length != 2) {
				throw new ChallengeException("Invalid format for policy bounds: " + policyBounds);
			}
			
			int min;
			int max;
			try {
				min = Integer.parseInt(policyBounds[0]);
				max = Integer.parseInt(policyBounds[1]);	
			} catch(NumberFormatException ex) {
				throw new ChallengeException("Invalid format for policy bounds: " + policyBounds, ex);
			}
			
			String policyValue = entry[1].replace(":", "");
			String password = entry[2];
			
			passwordEntries.add(new PasswordEntry(min, max, policyValue, password));
		}
		
		return passwordEntries;
	}
	
	protected Stream<PasswordEntry> getValidPasswords(List<PasswordEntry> entries) {
		return entries.stream().filter(this::isValidPassword);
	}
	
	protected boolean isValidPassword(PasswordEntry entry) {
		int valuesCount = (entry.getPassword().length() - entry.getPassword().replaceAll(entry.getPolicyValue(), "").length()) / entry.getPolicyValue().length();
		return entry.getPolicyX() <= valuesCount && valuesCount <= entry.getPolicyY();
	}

}
