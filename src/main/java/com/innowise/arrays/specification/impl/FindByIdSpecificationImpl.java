package com.innowise.arrays.specification.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.specification.ArraySpecification;

public class FindByIdSpecificationImpl implements ArraySpecification {

  private final long id;

  public FindByIdSpecificationImpl(long id) {
    this.id = id;
  }

  @Override
  public boolean specify(CustomArray array) {
    return array != null && array.getId() == id;
  }
}