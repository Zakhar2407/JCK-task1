package com.innowise.arrays.repository.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.repository.ArrayRepository;
import com.innowise.arrays.specification.ArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {

  private static final Logger logger = LogManager.getLogger(ArrayRepositoryImpl.class);
  private static ArrayRepositoryImpl instance;
  private final List<CustomArray> repositoryList;

  private ArrayRepositoryImpl() {
    this.repositoryList = new ArrayList<>();
  }

  public static ArrayRepositoryImpl getInstance() {
    if (instance == null) {
      instance = new ArrayRepositoryImpl();
    }
    return instance;
  }

  @Override
  public void add(CustomArray array) {
    if (array != null && !repositoryList.contains(array)) {
      repositoryList.add(array);
      logger.info("Array added to repository: id={}", array.getId());
    }
  }

  @Override
  public void remove(CustomArray array) {
    if (array != null) {
      repositoryList.remove(array);
      logger.info("Array removed from repository: id={}", array.getId());
    }
  }

  @Override
  public List<CustomArray> findBy(ArraySpecification specification) {
    List<CustomArray> resultList = new ArrayList<>();
    for (CustomArray array : repositoryList) {
      if (specification.specify(array)) {
        resultList.add(array);
      }
    }
    logger.info("Repository findBy executed. Found {} elements", resultList.size());
    return resultList;
  }

  @Override
  public void sort(Comparator<CustomArray> comparator) {
    repositoryList.sort(comparator);
    logger.info("Repository sorted using comparator");
  }

  @Override
  public List<CustomArray> getAll() {
    return new ArrayList<>(repositoryList);
  }
}