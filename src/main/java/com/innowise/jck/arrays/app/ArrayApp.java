package com.innowise.jck.arrays.app;

import com.innowise.jck.arrays.entity.CustomArray;
import com.innowise.jck.arrays.exception.CustomArrayException;
import com.innowise.jck.arrays.factory.CustomArrayFactory;
import com.innowise.jck.arrays.factory.impl.CustomArrayFactoryImpl;
import com.innowise.jck.arrays.parser.ArrayLineParser;
import com.innowise.jck.arrays.parser.impl.ArrayLineParserImpl;
import com.innowise.jck.arrays.reader.CustomArrayReader;
import com.innowise.jck.arrays.reader.impl.CustomArrayReaderImpl;
import com.innowise.jck.arrays.service.ArraySortService;
import com.innowise.jck.arrays.service.CustomArrayService;
import com.innowise.jck.arrays.service.impl.ArraySortServiceImpl;
import com.innowise.jck.arrays.service.impl.CustomArrayServiceImpl;
import com.innowise.jck.arrays.validator.ArrayLineValidator;


import com.innowise.jck.arrays.validator.impl.ArrayLineValidatorImpl;
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