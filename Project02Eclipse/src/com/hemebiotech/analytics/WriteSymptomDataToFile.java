package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes a Map of symptoms to an output file, one per line, in the format "symptom:count"
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    /**
     * Writes a Map of symptoms to an output file, one per line, in the format "symptom:count"
     *
     * @param symptoms a Map of symptoms to their counts
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter("Project02Eclipse/result.out");
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
