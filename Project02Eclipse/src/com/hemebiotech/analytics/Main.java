package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main class for the Analytics application.
 * <p>
 * This class reads a list of symptoms from a file, counts the occurrences of each symptom, sorts the list by key in ascending order and writes the sorted list to an output file.
 */
public class Main {
    /**
     * Main method for this application.
     *
     * @param args The command line arguments, currently unused.
     */
    public static void main(String[] args) {
        // Define the reader and writer with the appropriate files paths
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // Run the analytics in the order they should be run
        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> counts = counter.countSymptoms(symptoms);
        Map<String, Integer> sorted = counter.sortSymptoms(counts);
        counter.writeSymptoms(sorted);
    }
}
