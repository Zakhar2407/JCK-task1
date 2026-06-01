package com.innowise.jck.arrays.factory;

import com.innowise.jck.arrays.entity.CustomArray;

public interface CustomArrayFactory {

    //Creating method
    CustomArray createCustomArray(int[] elements);
}
