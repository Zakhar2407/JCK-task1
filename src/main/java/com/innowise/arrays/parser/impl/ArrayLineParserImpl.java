package com.innowise.arrays.parser.impl;

import com.innowise.arrays.parser.ArrayLineParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class ArrayLineParserImpl implements ArrayLineParser {

    //Log4j2
    private static final Logger logger = LogManager.getLogger(ArrayLineParserImpl.class);

    //Regex: to find "," near can be some spaces
    private static final String DELIMITER_REGEX = "\\s*,\\s*";

    //Default constructor
    public ArrayLineParserImpl() {
    }

    @Override
    public int[] parseLine(String line) {
        // Log the start of the parsing process
        logger.info("Starting to parse line");

        // Remove leading and trailing spaces to secure the input data
        String trimmedLine = line.trim();

        // Split the validated string into an array of sub-strings using the delimiter regex
        String[] stringNumbers = trimmedLine.split(DELIMITER_REGEX);

        // Allocate memory for the target primitive array with the exact matching length
        int[] resultElements = new int[stringNumbers.length];

        // Iterate through the string components and convert each one to a primitive int
        for (int i = 0; i < stringNumbers.length; i++) {
            // Safe to parse directly because the line has already been verified by the validator
            resultElements[i] = Integer.parseInt(stringNumbers[i]);
        }

        // Log successful completion along with the final array length
        logger.info("Line successfully parsed into int[] with size: {}", resultElements.length);

        return resultElements;
    }
}
