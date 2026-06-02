package com.innowise.jck.arrays.validator;

import com.innowise.jck.arrays.validator.impl.ArrayLineValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayLineValidatorTest {

    private ArrayLineValidator validator;

    @BeforeEach
    void setUp() {
        validator = new ArrayLineValidatorImpl();
    }

    @Test
    void testIsValidLine_ShouldReturnTrue_WhenLineContainsValidIntegersWithSpaces() {
        // Given
        String validLine = "  1, 5, -3, 24, 0  ";

        // When
        boolean isValid = validator.isValidLine(validLine);

        // Then
        assertTrue(isValid, "Validator failed to recognize a perfectly valid numerical line.");
    }

    @Test
    void testIsValidLine_ShouldReturnFalse_WhenLineContainsCharacters() {
        // Given
        String invalidLine = "1, 2, 3, four, 5";

        // When
        boolean isValid = validator.isValidLine(invalidLine);

        // Then
        assertFalse(isValid, "Validator incorrectly accepted a string containing alphabetical characters.");
    }
}
