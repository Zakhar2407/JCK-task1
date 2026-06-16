package com.innowise.arrays.comparator;

import com.innowise.arrays.entity.CustomArray;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<CustomArray> {

  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    int[] elements1 = o1.getElements();
    int[] elements2 = o2.getElements();

    if (elements1.length == 0 && elements2.length == 0) return 0;
    if (elements1.length == 0) return -1;
    if (elements2.length == 0) return 1;

    return Integer.compare(elements1[0], elements2[0]);
  }
}