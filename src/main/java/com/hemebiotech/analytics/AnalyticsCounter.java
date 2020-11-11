package com.hemebiotech.analytics;

import com.hemebiotech.analytics.reader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.utils.UtilCounter;
import com.hemebiotech.analytics.writer.WriteSortedSymptoms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main Class of the Program
 *
 */
public class AnalyticsCounter {

	/**
	 * @param args command-line arguments
	 *
	 */
	public static void main(String args[]) throws Exception {
		// Read the file with the util class & return List of String
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();

		//Count the symptoms and put them in a Map : values:symptoms/keys:number of appearance
		Map<String, Integer> existingSymptoms = UtilCounter.countSymptoms(symptoms);

		//Write the sorted symptoms in the output file
		WriteSortedSymptoms writer = new WriteSortedSymptoms("result.out", existingSymptoms);
		writer.writeSymptoms();
	}
}
