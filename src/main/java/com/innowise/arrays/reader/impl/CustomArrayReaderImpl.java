package com.innowise.arrays.reader.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.exception.CustomArrayException;
import com.innowise.arrays.factory.CustomArrayFactory;
import com.innowise.arrays.parser.ArrayLineParser;
import com.innowise.arrays.reader.CustomArrayReader;
import com.innowise.arrays.validator.ArrayLineValidator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomArrayReaderImpl implements CustomArrayReader {

    private static final Logger logger = LogManager.getLogger(CustomArrayReaderImpl.class);

    private final CustomArrayFactory factory;
    private final ArrayLineParser parser;
    private final ArrayLineValidator validator;

    public CustomArrayReaderImpl(ArrayLineValidator validator, ArrayLineParser parser, CustomArrayFactory factory) {
        this.validator = validator;
        this.parser = parser;
        this.factory = factory;
    }

    @Override
    public List<CustomArray> readArraysFromFile(String filePath) throws CustomArrayException {
        logger.info("Starting to read file from path: {}", filePath);

        if (filePath == null) {
            logger.error("File path validation failed: path is null");
            throw new CustomArrayException("File path cannot be null");
        }

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            logger.error("File not found at specified path: {}", filePath);
            throw new CustomArrayException("Target data file was not found: " + filePath);
        }

        List<CustomArray> resultList = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {

            // We process lines with a safe terminal approach to avoid unhandled standard exceptions
            lines.forEach(line -> {
                if (validator.isValidLine(line)) {
                    int[] parsedArray = parser.parseLine(line);
                    CustomArray customArray = factory.createCustomArray(parsedArray);
                    resultList.add(customArray);
                }
            });

        } catch (IOException e) {
            logger.error("NIO standard exception occurred while accessing file: {}", filePath, e);
            // Wrapping standard IOException into your custom user exception
            throw new CustomArrayException("Failed to read array data from file due to I/O error", e);
        }

        logger.info("Successfully read and processed {} CustomArray objects", resultList.size());
        return resultList;
    }
}
