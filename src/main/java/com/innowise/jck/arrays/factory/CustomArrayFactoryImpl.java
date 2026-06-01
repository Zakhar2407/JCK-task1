package com.innowise.jck.arrays.factory;

import com.innowise.jck.arrays.entity.CustomArray;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    //Default constructor
    public CustomArrayFactoryImpl() {
    }

    //Implementation
    @Override
    public CustomArray createCustomArray(int[] elements) {
        return new CustomArray(elements);
    }
}
