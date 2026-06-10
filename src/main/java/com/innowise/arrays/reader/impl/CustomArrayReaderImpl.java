package com.innowise.arrays.reader.impl;

import com.innowise.arrays.exception.CustomArrayException;
import com.innowise.arrays.reader.CustomArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CustomArrayReaderImpl implements CustomArrayReader {

  private static final Logger logger = LogManager.getLogger(CustomArrayReaderImpl.class);


  @Override
  public List<String> readLinesFromFile(String filePath) throws CustomArrayException {
    Path path = Paths.get(filePath);

    try {
      List<String> lines = Files.readAllLines(path);
      logger.info("Successfully read {} line(s) from file: {}", lines.size(), filePath);
      return lines;

    } catch (IOException e) {
      logger.error("Failed to read file: {}", filePath, e);
      throw new CustomArrayException(String.format("Failed to read file: %s", filePath), e);
    }
  }
}