package com.tecacet.jtemplates.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class TestUtil {

    private static final String CONTROL_DIRECTORY = "control";
    private static final String OUTPUT_DIRECTORY = "output";

    private TestUtil() {

    }

    public static void compareLineByLine(String filename) throws IOException {
        String controlFileName = CONTROL_DIRECTORY + File.separator + filename;
        String outputFileName = OUTPUT_DIRECTORY + File.separator + filename;
        List<String> control = Files.readAllLines(Paths.get(controlFileName));
        List<String> output = Files.readAllLines(Paths.get(outputFileName));
        for (int i = 0; i < control.size(); i++) {
            assertEquals(control.get(i).trim(), output.get(i).trim());
        }
    }


}
