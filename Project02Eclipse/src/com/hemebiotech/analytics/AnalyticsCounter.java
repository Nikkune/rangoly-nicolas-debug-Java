package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    ISymptomReader reader;
    ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

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

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<String, Integer>(symptoms);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String[] args) throws Exception {
        // first read input
        BufferedReader reader = new BufferedReader(new FileReader("D:/Projects/rangoly-nicolas-debug-Java/Project02Eclipse/symptoms.txt"));
        String line = reader.readLine();

        while (line != null) {
            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headacheCount++;
                System.out.println("number of headaches: " + headacheCount);
            } else if (line.equals("rash")) {
                rashCount++;
            } else if (line.equals("dialated pupils")) {
                pupilCount++;
            }

            line = reader.readLine();    // read next line
        }

        reader.close();

        // next generate output
        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
    }
}
