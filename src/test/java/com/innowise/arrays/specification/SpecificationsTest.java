package com.innowise.arrays.specification;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.specification.impl.FindByMinLessThanSpecificationImpl;
import com.innowise.arrays.specification.impl.FindBySumGreaterThanSpecificationImpl;
import com.innowise.arrays.warehouse.ArrayStatistics;
import com.innowise.arrays.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecificationsTest {

  @BeforeEach
  void setUp() {
    ArrayWarehouse.getInstance().updateStatistics(1L, new ArrayStatistics(100, 25.0, 40, 10));
  }

  @ParameterizedTest
  @CsvSource({
          "50,  false",
          "100, false",
          "150, false"
  })
  void testSumGreaterThanSpecification(int limit, boolean expectedResult) {
    CustomArray array = new CustomArray( new int[]{});
    FindBySumGreaterThanSpecificationImpl specification = new FindBySumGreaterThanSpecificationImpl(limit);

    assertEquals(expectedResult, specification.specify(array));
  }

  @ParameterizedTest
  @CsvSource({
          "15, true",
          "10, false",
          "5,  false"
  })
  void testMinLessThanSpecification(int limit, boolean expectedResult) {
    CustomArray array = new CustomArray( new int[]{});
    FindByMinLessThanSpecificationImpl specification = new FindByMinLessThanSpecificationImpl(limit);

    assertEquals(expectedResult, specification.specify(array));
  }
}