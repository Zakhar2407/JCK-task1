package com.innowise.arrays.service;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.exception.CustomArrayException;
import com.innowise.arrays.service.impl.CustomArrayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayServiceImplTest {

    private CustomArrayService arrayService;

    @BeforeEach
    void setUp() {
        arrayService = new CustomArrayServiceImpl();
    }

    @Test
    void testFindMin_ShouldReturnMinimum_WhenArrayContainsNegativeAndPositiveNumbers() throws CustomArrayException {
        // Given
        int[] sourceData = {12, -3, 45, 0, -15, 8};
        CustomArray customArray = new CustomArray(sourceData);
        int expectedMin = -15;

        // When
        int actualMin = arrayService.findMin(customArray);

        // Then
        assertEquals(expectedMin, actualMin, "The minimum value calculated is incorrect.");
    }

    @Test
    void testCalculateAverage_ShouldReturnCorrectDouble_WhenArrayHasEvenSize() throws CustomArrayException {
        // Given
        int[] sourceData = {1, 2, 3, 4};
        CustomArray customArray = new CustomArray(sourceData);
        double expectedAverage = 2.5;

        // When
        double actualAverage = arrayService.calculateAverage(customArray);

        // Then
        assertEquals(expectedAverage, actualAverage, 0.001, "The average value calculation failed.");
    }

    @Test
    void testFindMax_ShouldThrowCustomArrayException_WhenArrayIsEmpty() {
        // Given
        int[] emptyData = {};
        CustomArray customArray = new CustomArray(emptyData);

        // When & Then
        assertThrows(CustomArrayException.class, () -> {
            arrayService.findMax(customArray);
        }, "Should throw CustomArrayException for an empty array reference.");
    }
}