package com.innowise.jck.arrays.reader;

import com.innowise.jck.arrays.entity.CustomArray;
import com.innowise.jck.arrays.exception.CustomArrayException;

import java.util.List;

public interface CustomArrayReader {

    List<CustomArray> readArraysFromFile(String filePath) throws CustomArrayException;
}
