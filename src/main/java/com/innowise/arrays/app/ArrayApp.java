package com.innowise.arrays.app;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.exception.CustomArrayException;
import com.innowise.arrays.factory.CustomArrayFactory;
import com.innowise.arrays.factory.impl.CustomArrayFactoryImpl;
import com.innowise.arrays.parser.ArrayLineParser;
import com.innowise.arrays.parser.impl.ArrayLineParserImpl;
import com.innowise.arrays.reader.CustomArrayReader;
import com.innowise.arrays.reader.impl.CustomArrayReaderImpl;
import com.innowise.arrays.service.ArraySortService;
import com.innowise.arrays.service.CustomArrayService;
import com.innowise.arrays.service.impl.ArraySortServiceImpl;
import com.innowise.arrays.service.impl.CustomArrayServiceImpl;
import com.innowise.arrays.validator.ArrayLineValidator;


import com.innowise.arrays.validator.impl.ArrayLineValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ArrayApp {

    private static final Logger logger = LogManager.getLogger(ArrayApp.class);

    private static final String FILE_PATH = "data/arrays.txt";

    static void main(String[] args) {
        logger.info("Application context initializing...");

        ArrayLineValidator validator = new ArrayLineValidatorImpl();
        ArrayLineParser parser = new ArrayLineParserImpl();
        CustomArrayFactory factory = new CustomArrayFactoryImpl();

        CustomArrayReader reader = new CustomArrayReaderImpl(validator, parser, factory);

        CustomArrayService arrayService = new CustomArrayServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        logger.info("Application infrastructure successfully assembled.");

        try {
            List<CustomArray> arrays = reader.readArraysFromFile(FILE_PATH);

            if (arrays.isEmpty()) {
                logger.warn("No valid arrays were processed from the file.");
                return;
            }

            CustomArray targetArray = arrays.get(0);
            logger.info("Demonstrating statistics for the first processed array");

            int min = arrayService.findMin(targetArray);
            int max = arrayService.findMax(targetArray);
            int sum = arrayService.calculateSum(targetArray);
            double avg = arrayService.calculateAverage(targetArray);

            logger.info("Calculated Metrics -> Min: {}, Max: {}, Sum: {}, Average: {}", min, max, sum, avg);

            logger.info("Executing custom insertion sort demo...");
            sortService.insertionSort(targetArray);

            logger.info("Application execution finished successfully.");

        } catch (CustomArrayException e) {
            logger.error("Critical business standard violation or I/O failure occurred", e);
        }
    }
}