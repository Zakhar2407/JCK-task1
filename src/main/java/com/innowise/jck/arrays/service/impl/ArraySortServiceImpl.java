package com.innowise.jck.arrays.service.impl;

import com.innowise.jck.arrays.entity.CustomArray;
import com.innowise.jck.arrays.exception.CustomArrayException;
import com.innowise.jck.arrays.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {

    private static final Logger logger = LogManager.getLogger(ArraySortServiceImpl.class);

    public ArraySortServiceImpl() {
    }

    @Override
    public void bubbleSort(CustomArray customArray) throws CustomArrayException {
        logger.info("Starting bubbleSort operation");

        // Rule 21: Isolate the primitive array to prevent chaining syntax
        int[] elements = customArray.getElements();

        if (elements == null) {
            logger.error("Array is null, sorting aborted");
            throw new CustomArrayException("Cannot sort a null array reference");
        }

        int length = elements.length;

        // Classic bubble sort algorithm logic
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }

        logger.info("BubbleSort operation completed successfully");
    }

    @Override
    public void insertionSort(CustomArray customArray) throws CustomArrayException {
        logger.info("Starting insertionSort operation");

        int[] elements = customArray.getElements();

        if (elements == null) {
            logger.error("Array is null, sorting aborted");
            throw new CustomArrayException("Cannot sort a null array reference");
        }

        int length = elements.length;

        // Classic insertion sort algorithm logic
        for (int i = 1; i < length; ++i) {
            int key = elements[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = key;
        }

        logger.info("InsertionSort operation completed successfully");
    }
}