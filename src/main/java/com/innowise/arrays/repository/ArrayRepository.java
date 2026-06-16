package com.innowise.arrays.repository;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {

  void add(CustomArray array);

  void remove(CustomArray array);

  List<CustomArray> findBy(ArraySpecification specification);

  void sort(Comparator<CustomArray> comparator);

  List<CustomArray> getAll();
}