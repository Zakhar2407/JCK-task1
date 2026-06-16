package com.innowise.arrays.observer;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.observer.impl.ArrayObserverImpl;
import com.innowise.arrays.warehouse.ArrayStatistics;
import com.innowise.arrays.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStatisticsObserverImplTest {

  private ArrayObserverImpl observer;

  @BeforeEach
  void setUp() {
    observer = new ArrayObserverImpl();
    ArrayWarehouse.getInstance().removeStatistics(1L);
  }

  @Test
  void testUpdateWithValidElements() {
    CustomArray array = new CustomArray( new int[]{10, -2, 5, 3}); // sum=16, avg=4.0, max=10, min=-2

    observer.update(array);

    Optional<ArrayStatistics> statsOpt = ArrayWarehouse.getInstance().getStatistics(1L);
    assertTrue(statsOpt.isPresent());

    ArrayStatistics stats = statsOpt.get();

    assertAll("ArrayStatistics validation",
            () -> assertEquals(16, stats.sum()),
            () -> assertEquals(4.0, stats.average(), 0.001),
            () -> assertEquals(10, stats.max()),
            () -> assertEquals(-2, stats.min())
    );
  }
}