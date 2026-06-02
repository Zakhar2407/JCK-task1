package com.innowise.jck.arrays.service;

import com.innowise.jck.arrays.entity.CustomArray;
import com.innowise.jck.arrays.exception.CustomArrayException;

public interface CustomArrayService {

    int findMin(CustomArray customArray) throws CustomArrayException;

    int findMax(CustomArray customArray) throws CustomArrayException;

    int calculateSum(CustomArray customArray) throws CustomArrayException;

    double calculateAverage(CustomArray customArray) throws CustomArrayException;

    int countPositiveElements(CustomArray customArray) throws CustomArrayException;

    int countNegativeElements(CustomArray customArray) throws CustomArrayException;

    void replaceElements(CustomArray customArray, int targetValue, int newValue) throws CustomArrayException;
}