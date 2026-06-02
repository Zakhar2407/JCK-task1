package com.innowise.jck.arrays.service;

import com.innowise.jck.arrays.entity.CustomArray;
import com.innowise.jck.arrays.exception.CustomArrayException;
import com.innowise.jck.arrays.service.impl.ArraySortServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraySortServiceImplTest {

    private ArraySortService sortService;

    @BeforeEach
    void setUp() {
        sortService = new ArraySortServiceImpl();
    }

    @Test
    void testBubbleSort_ShouldSortArrayAscending_WhenInputIsUnsorted() throws CustomArrayException {
        // Given
        int[] sourceData = {7, -2, 15, 0, 6};
        CustomArray customArray = new CustomArray(sourceData);
        int[] expectedData = {-2, 0, 6, 7, 15};

        // When
        sortService.bubbleSort(customArray);
        int[] actualData = customArray.getElements();

        // Then
        assertArrayEquals(expectedData, actualData, "The bubble sort algorithm did not sort data correctly.");
    }

    @Test
    void testInsertionSort_ShouldSortArrayAscending_WhenInputIsUnsorted() throws CustomArrayException {
        // Given
        int[] sourceData = {5, 1, 4, 2, 8};
        CustomArray customArray = new CustomArray(sourceData);
        int[] expectedData = {1, 2, 4, 5, 8};

        // When
        sortService.insertionSort(customArray);
        int[] actualData = customArray.getElements();

        // Then
        assertArrayEquals(expectedData, actualData, "The insertion sort algorithm did not sort data correctly.");
    }
}