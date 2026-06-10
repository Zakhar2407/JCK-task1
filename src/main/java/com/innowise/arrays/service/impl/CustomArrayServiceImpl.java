package com.innowise.arrays.service.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.exception.CustomArrayException;
import com.innowise.arrays.service.CustomArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of CustomArrayService adhering to strict code clean standards.
 */
public class CustomArrayServiceImpl implements CustomArrayService {

    private static final Logger logger = LogManager.getLogger(CustomArrayServiceImpl.class);

    @Override
    public int findMin(CustomArray customArray) throws CustomArrayException {
        logger.info("Executing findMin operation");

        int[] elements = customArray.getElements();

        // Validation against empty data
        if (elements == null || elements.length == 0) {
            logger.error("Array is empty or null, cannot determine minimum value");
            throw new CustomArrayException("Cannot find minimum in an empty array");
        }

        int min = elements[0];

        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }

        logger.info("Minimum value successfully found: {}", min);
        return min;
    }

    @Override
    public int findMax(CustomArray customArray) throws CustomArrayException {
        logger.info("Executing findMax operation");

        int[] elements = customArray.getElements();

        if (elements == null || elements.length == 0) {
            logger.error("Array is empty or null, cannot determine maximum value");
            throw new CustomArrayException("Cannot find maximum in an empty array");
        }

        int max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }

        logger.info("Maximum value successfully found: {}", max);
        return max;
    }

    @Override
    public int calculateSum(CustomArray customArray) throws CustomArrayException {
        logger.info("Executing calculateSum operation");

        int[] elements = customArray.getElements();

        if (elements == null) {
            logger.error("Array reference is null");
            throw new CustomArrayException("Cannot calculate sum for null reference");
        }

        int sum = 0;
        for (int element : elements) {
            sum += element;
        }

        logger.info("Sum successfully calculated: {}", sum);
        return sum;
    }

    @Override
    public double calculateAverage(CustomArray customArray) throws CustomArrayException {
        logger.info("Executing calculateAverage operation");

        int[] elements = customArray.getElements();

        // division by zero
        if (elements == null || elements.length == 0) {
            logger.error("Array is empty or null, division by zero prevented");
            throw new CustomArrayException("Cannot calculate average for an empty array");
        }

        int sum = calculateSum(customArray);

        double average = (double) sum / elements.length;

        logger.info("Average successfully calculated: {}", average);
        return average;
    }

    @Override
    public int countPositiveElements(CustomArray customArray) throws CustomArrayException {
        logger.info("Executing countPositiveElements operation");

        int[] elements = customArray.getElements();

        if (elements == null) {
            logger.error("Array reference is null");
            throw new CustomArrayException("Cannot count elements for null reference");
        }

        int count = 0;
        for (int element : elements) {
            if (element > 0) {
                count++;
            }
        }

        logger.info("Positive elements counted: {}", count);
        return count;
    }

    @Override
    public int countNegativeElements(CustomArray customArray) throws CustomArrayException {
        logger.info("Executing countNegativeElements operation");

        int[] elements = customArray.getElements();

        if (elements == null) {
            logger.error("Array reference is null");
            throw new CustomArrayException("Cannot count elements for null reference");
        }

        int count = 0;
        for (int element : elements) {
            if (element < 0) {
                count++;
            }
        }

        logger.info("Negative elements counted: {}", count);
        return count;
    }

    @Override
    public void replaceElements(CustomArray customArray, int targetValue, int newValue) throws CustomArrayException {
        logger.info("Executing replaceElements operation: replacing {} with {}", targetValue, newValue);

        int[] elements = customArray.getElements();

        if (elements == null) {
            logger.error("Array reference is null, cannot replace elements");
            throw new CustomArrayException("Cannot modify elements for null reference");
        }

        // Modifying elements in place using local primitive array variable
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == targetValue) {
                elements[i] = newValue;
            }
        }

        logger.info("Elements replacement completed successfully");
    }
}