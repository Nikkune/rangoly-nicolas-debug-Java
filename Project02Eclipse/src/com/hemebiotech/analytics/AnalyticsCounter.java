package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * AnalyticsCounter is a class that counts the occurrences of each symptom in a list of symptoms obtained from
 * an ISymptomReader, and writes the results to an ISymptomWriter
 */
public class AnalyticsCounter {
    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Constructor for AnalyticsCounter
     *
     * @param reader an ISymptomReader
     * @param writer an ISymptomWriter
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Returns a list of symptoms from the ISymptomReader
     * The list may contain duplicates
     *
     * @return a list of symptoms
     */
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    /**
     * Counts the occurrences of each symptom in the provided list.
     *
     * @param symptoms a list of symptoms that may contain duplicates
     * @return a map where the keys are symptoms and the values are the number of times each symptom appears in the list
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> result = new HashMap<String, Integer>();

        for (String symptom : symptoms) {
            if (result.containsKey(symptom)) {
                result.put(symptom, result.get(symptom) + 1);
            } else {
                result.put(symptom, 1);
            }
        }

        return result;
    }

    /**
     * Sorts the provided map of symptoms by key in ascending order.
     *
     * @param symptoms a map of symptoms to be sorted
     * @return a sorted map of symptoms
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<String, Integer>(symptoms);
    }

    /**
     * Writes the provided map of symptoms to the ISymptomWriter.
     *
     * @param symptoms a map of symptoms to be written
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.WriteSymptoms(symptoms);
    }
}
