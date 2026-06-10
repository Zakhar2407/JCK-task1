package com.innowise.arrays.service;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.exception.CustomArrayException;

public interface ArraySortService {

    void bubbleSort(CustomArray customArray) throws CustomArrayException;

    void insertionSort(CustomArray customArray) throws CustomArrayException;
}