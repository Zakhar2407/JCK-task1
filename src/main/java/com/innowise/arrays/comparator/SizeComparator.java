package com.innowise.arrays.comparator;

import com.innowise.arrays.entity.CustomArray;
import java.util.Comparator;

public class SizeComparator implements Comparator<CustomArray> {

  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return Integer.compare(o1.size(), o2.size());
  }
}