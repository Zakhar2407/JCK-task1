package com.innowise.jck.arrays.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayLineValidatorImpl implements ArrayLineValidator {

    //Initialization of Log4j2
    private static final Logger logger = LogManager.getLogger(ArrayLineValidatorImpl.class);

    //Initialization of reg. values
    private static final String VALID_ARRAY_REGEX = "^-?\\d+(\\s*,\\s*-?\\d+)*$";

    //Default constructor
    public ArrayLineValidatorImpl() {
    }

    @Override
    public boolean isValidLine (String line) {
        if (line == null) {
            logger.warn("Validation failed: input line is empty");
            return false;
        }

        //Creating trimming validation
        String trimmedLine = line.trim();

        if (trimmedLine.isEmpty()) {
            logger.info("Validation skipped: line is empty or contains only spaces");
            return false;
        }

        //isMatches
        boolean matches = trimmedLine.matches(VALID_ARRAY_REGEX);

        if (!matches) {
            logger.warn("Validation failed for line: [{}]", trimmedLine);
        } else {
            logger.info("Line successfully validated");
        }

        return matches;
    }
}
