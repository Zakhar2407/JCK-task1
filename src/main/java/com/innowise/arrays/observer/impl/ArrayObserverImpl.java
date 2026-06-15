package com.innowise.arrays.observer.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.warehouse.ArrayStatistics;
import com.innowise.arrays.warehouse.ArrayWarehouse;
import com.innowise.arrays.observer.ArrayObserver;

public class ArrayObserverImpl implements ArrayObserver {

  @Override
  public void update(CustomArray customArray) {
    if (customArray == null) {
      return;
    }

    int[] elements = customArray.getElements();

    if (elements.length == 0) {
      ArrayStatistics emptyStats = new ArrayStatistics(0, 0.0, 0, 0);
      ArrayWarehouse.getInstance().updateStatistics(customArray.getId(), emptyStats);
      return;
    }

    int sum = 0;
    int max = elements[0];
    int min = elements[0];

    for (int element : elements) {
      sum += element;
      if (element > max) {
        max = element;
      }
      if (element < min) {
        min = element;
      }
    }

    double average = (double) sum / elements.length;

    ArrayStatistics statistics = new ArrayStatistics(sum, average, max, min);
    ArrayWarehouse.getInstance().updateStatistics(customArray.getId(), statistics);
  }
}
