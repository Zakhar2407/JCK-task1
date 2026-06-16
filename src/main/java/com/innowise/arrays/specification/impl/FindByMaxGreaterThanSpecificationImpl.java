package com.innowise.arrays.specification.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.specification.ArraySpecification;
import com.innowise.arrays.warehouse.ArrayWarehouse;

public class FindByMaxGreaterThanSpecificationImpl implements ArraySpecification {

  private final int maxLimit;

  public FindByMaxGreaterThanSpecificationImpl(int maxLimit) {
    this.maxLimit = maxLimit;
  }

  @Override
  public boolean specify(CustomArray array) {
    if (array == null) {
      return false;
    }
    return ArrayWarehouse.getInstance()
            .getStatistics(array.getId())
            .map(stats -> stats.max() > maxLimit)
            .orElse(false);
  }
}