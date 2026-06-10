package com.innowise.arrays.reader;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.exception.CustomArrayException;

import java.util.List;

public interface CustomArrayReader {

    List<CustomArray> readArraysFromFile(String filePath) throws CustomArrayException;
}
