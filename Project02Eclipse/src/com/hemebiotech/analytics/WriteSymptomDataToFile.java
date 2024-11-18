package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
    private final String filepath;

    /**
     *
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes a Map of symptoms to an output file, one per line, in the format "symptom:count"
     *
     * @param symptoms a Map of symptoms to their counts
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            try {
                FileWriter writer = new FileWriter(filepath);
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
