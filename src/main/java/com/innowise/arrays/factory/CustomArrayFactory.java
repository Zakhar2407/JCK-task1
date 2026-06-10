package com.innowise.arrays.factory;

import com.innowise.arrays.entity.CustomArray;

public interface CustomArrayFactory {

    //Creating method
    CustomArray createCustomArray(int[] elements);
}
