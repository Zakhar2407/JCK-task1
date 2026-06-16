package com.innowise.arrays.specification.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.specification.ArraySpecification;
import com.innowise.arrays.warehouse.ArrayWarehouse;

public class FindByMinLessThanSpecificationImpl implements ArraySpecification {

  private final int minLimit;

  public FindByMinLessThanSpecificationImpl(int minLimit) {
    this.minLimit = minLimit;
  }

  @Override
  public boolean specify(CustomArray array) {
    if (array == null) {
      return false;
    }
    return ArrayWarehouse.getInstance()
            .getStatistics(array.getId())
            .map(stats -> stats.min() < minLimit)
            .orElse(false);
  }
}