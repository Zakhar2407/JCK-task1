package com.innowise.jck.arrays.parser;

import com.innowise.jck.arrays.parser.impl.ArrayLineParserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayLineParserImplTest {

    private ArrayLineParser parser;

    @BeforeEach
    void setUp() {
        parser = new ArrayLineParserImpl();
    }

    @Test
    void testParseLine_ShouldReturnPrimitiveArray_WhenLineIsValidWithSpaces() {
        // Given
        String inputLine = "  5, 1, -4, 2, 8  ";
        int[] expectedArray = {5, 1, -4, 2, 8};

        // When
        int[] actualArray = parser.parseLine(inputLine);

        // Then
        assertArrayEquals(expectedArray, actualArray, "The parser failed to convert the string line into correct int[].");
    }
}