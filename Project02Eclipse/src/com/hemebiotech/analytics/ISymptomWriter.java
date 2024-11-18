package com.hemebiotech.analytics;

import java.util.Map;

/**
 * An interface for writing symptom data to a destination.
 * The implementation of this interface will define how the symptoms are written.
 * The important part is to ensure that the data is accurately represented in the output.
 */
public interface ISymptomWriter {
    /**
     * Writes a Map of symptoms to an output destination, with the exact format determined by the implementing class
     * @param symptoms a Map of symptoms to their counts
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
