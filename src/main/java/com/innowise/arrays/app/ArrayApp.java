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

import java.util.ArrayList;
import java.util.List;

public class ArrayApp {

    private static final Logger logger = LogManager.getLogger(ArrayApp.class);
    private static final String FILE_PATH = "data/arrays.txt";

    static void main(String[] args) {

        CustomArrayReader reader = new CustomArrayReaderImpl();
        ArrayLineValidator validator = new ArrayLineValidatorImpl();
        ArrayLineParser parser = new ArrayLineParserImpl();
        CustomArrayFactory factory = new CustomArrayFactoryImpl();

        CustomArrayService arrayService = new CustomArrayServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        logger.info("Application infrastructure successfully assembled.");

        try {
            List<String> lines = reader.readLinesFromFile(FILE_PATH);
            List<CustomArray> customArrays = new ArrayList<>();

            for (String line : lines) {
                if (line.isBlank()) {
                    logger.warn("Skipping blank line");
                    continue;
                }

                if (!validator.isValidLine(line)) {
                    logger.warn("Validation failed, skipping line: [{}]", line);
                    continue;
                }

                int[] numbers = parser.parseLine(line);

                if (numbers.length == 0) {
                    logger.warn("No integers found in line: [{}]", line);
                    continue;
                }

                CustomArray customArray = factory.createCustomArray(numbers);
                customArrays.add(customArray);
                logger.info("Successfully created and added: {}", customArray);
            }

            if (customArrays.isEmpty()) {
                logger.warn("No valid arrays were processed from the file.");
                return;
            }

            demonstrateArrayProcessing(arrayService, sortService, customArrays);

            logger.info("Application execution finished successfully.");

        } catch (CustomArrayException e) {
            logger.error("Critical business standard violation or I/O failure occurred", e);
        }
    }

    private static void demonstrateArrayProcessing(CustomArrayService arrayService,
                                                   ArraySortService sortService,
                                                   List<CustomArray> arrays) throws CustomArrayException {

        logger.info("--- Starting array processing demonstration ---");

        for (CustomArray array : arrays) {
            logger.info("Processing array: {}", array);

            // Подсчет статистики
            int min = arrayService.findMin(array);
            int max = arrayService.findMax(array);
            int sum = arrayService.calculateSum(array);
            double avg = arrayService.calculateAverage(array);

            logger.info("Metrics -> Min: {}, Max: {}, Sum: {}, Average: {}", min, max, sum, avg);

            logger.info("Executing custom insertion sort...");

            int[] original = array.getElements();

            sortService.insertionSort(array);
            logger.info("After insertion sort: {}", array);

            array.setElements(original);
        }

        logger.info("--- Array processing demonstration finished ---");
    }
}