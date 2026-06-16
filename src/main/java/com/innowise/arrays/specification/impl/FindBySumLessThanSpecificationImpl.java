package com.innowise.arrays.specification.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.specification.ArraySpecification;
import com.innowise.arrays.warehouse.ArrayWarehouse;

public class FindBySumLessThanSpecificationImpl implements ArraySpecification {

  private final int sumLimit;

  public FindBySumLessThanSpecificationImpl(int sumLimit) {
    this.sumLimit = sumLimit;
  }

  @Override
  public boolean specify(CustomArray array) {
    if (array == null) {
      return false;
    }
    return ArrayWarehouse.getInstance()
            .getStatistics(array.getId())
            .map(stats -> stats.sum() < sumLimit)
            .orElse(false);
  }
}