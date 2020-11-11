package com.hemebiotech.analytics.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class with counters methods
 *
 */

public class UtilCounter {

    /**
     * @param symptoms List of one symptoms per line.
     * @return a Map with String values (symptoms) and Integer keys (number of appearance)
     */
    public static Map<String, Integer> countSymptoms(List<String> symptoms) {

        Map<String, Integer> existingSymptoms = new HashMap<String, Integer>();
        int line = 0;

            for(String symptom : symptoms) {
            line++;
            //If the line is empty log the line number
            if(symptom == "")
                System.out.println("line " + line + " is empty");
            //If symptom exist increment the map's value
            if(existingSymptoms.containsKey(symptom))
                existingSymptoms.put(symptom, existingSymptoms.get(symptom) + 1);
            else
                //else put the symptom in the map and instantiate the value to one
                existingSymptoms.put(symptom, 1);
        }
            return existingSymptoms;
    }
}
