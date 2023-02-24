package edu.uga.cs1302.quiz;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

// Represent a Question
public class Question {

	public static final int POSSIBLE_CHOICES = 3;

	// country and options
	private Country country;
	private ArrayList<String> options;

	// Constructor
	public Question(Country country, ArrayList<String> allContinents) {
		this.country = country;

		options = new ArrayList<>();
		options.add(country.getContinent());

		
		// while not all options added
		while (options.size() != POSSIBLE_CHOICES) {
			int randomValue = ThreadLocalRandom.current().nextInt(allContinents.size());
			String continent = allContinents.get(randomValue);
			if (!options.contains(continent)) { // if no already present
				// add continent at random location
				options.add(ThreadLocalRandom.current().nextInt(options.size() + 1), continent);
			}
		}

	}

	public Country getCountry() {
		return country;
	}

	public ArrayList<String> getOptions() {
		return options;
	}
	
	public boolean answer(int index) {
		return country.getContinent().equals(options.get(index));
	}

}
