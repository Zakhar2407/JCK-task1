package com.innowise.jck.arrays.service;

import com.innowise.jck.arrays.entity.CustomArray;
import com.innowise.jck.arrays.exception.CustomArrayException;

public interface ArraySortService {

    void bubbleSort(CustomArray customArray) throws CustomArrayException;

    void insertionSort(CustomArray customArray) throws CustomArrayException;
}