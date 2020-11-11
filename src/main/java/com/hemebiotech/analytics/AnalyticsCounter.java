package com.hemebiotech.analytics;

import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.WriteSortedSymptoms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// Read the file with the util class & return List of String
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();

		Map<String, Integer> existingSymptoms = new HashMap<String, Integer>();
		int line = 0;

		for (String symptom : symptoms) {
			line++;
			//If the line is empty log the line number
			if (symptom.equals(""))
				System.out.println("line " + line + " is empty");
			//If symptom exist increment the map's value
			if (existingSymptoms.containsKey(symptom))
				existingSymptoms.put(symptom, existingSymptoms.get(symptom) + 1);
			else
				//else put the symptom in the map and instantiate the value to one
				existingSymptoms.put(symptom, 1);

			//Write the sorted symptoms in the output file
			WriteSortedSymptoms writer = new WriteSortedSymptoms("result.out", existingSymptoms);
			writer.writeSymptoms();
		}
	}
}
