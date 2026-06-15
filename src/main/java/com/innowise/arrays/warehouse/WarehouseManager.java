package com.innowise.arrays.warehouse;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.observer.ArrayObserver;
import com.innowise.arrays.observer.impl.ArrayObserverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WarehouseManager {

  private static final Logger logger = LogManager.getLogger(WarehouseManager.class);

  private final ArrayWarehouse warehouse;

  public WarehouseManager() {
    this.warehouse = ArrayWarehouse.getInstance();
  }

  public void attachObserver(CustomArray array) {
    ArrayObserver observer = new ArrayObserverImpl();
    array.setObserver(observer);
    observer.update(array);
    logger.info("Observer attached and initial statistics computed for id={}", array.getId());
  }

  public void detachObserver(CustomArray array) {
    long arrayId = array.getId();
    array.setObserver(null);
    warehouse.removeStatistics(arrayId);
    logger.info("Observer detached and statistics removed for id={}", arrayId);
  }

  public void initializeAll(List<CustomArray> arrays) {
    for (CustomArray array : arrays) {
      attachObserver(array);
    }
  }
}