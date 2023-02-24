package edu.uga.cs1302.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

// Collection of Questions
public class QuestionCollection {

	// list of countries and continents
	private ArrayList<Country> countries;
	private ArrayList<String> continents;

	public QuestionCollection() {
		countries = new ArrayList<>();
		continents  = new ArrayList<>();
	}

	
	// read all countries
	public void readCountries(String fileName) throws IOException {
		File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        BufferedReader reader = Files.newBufferedReader(file.toPath());
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withIgnoreHeaderCase().withTrim());
		
		for (CSVRecord csvRecord : csvParser) {
			String country = csvRecord.get(0);
			String continent = csvRecord.get(1);
			
			if(!continents.contains(continent))
				continents.add(continent);
			
			countries.add(new Country(country, continent));
		}
		
		continents.add("Antartica");
		
		csvParser.close();
	}
	
	
	public Country getCountry(int index) {
		return countries.get(index);
	}
	
	
	public int size() {
		return countries.size();
	}
	
	
	public ArrayList<String> getContinents() {
		return continents;
	}

}
