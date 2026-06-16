package com.innowise.arrays.comparator;

import com.innowise.arrays.entity.CustomArray;
import java.util.Comparator;

public class IdComparator implements Comparator<CustomArray> {

  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return Long.compare(o1.getId(), o2.getId());
  }
}