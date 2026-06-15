package com.innowise.arrays.util;

public class IdGenerator {

  private static long counter = 0L;

  private IdGenerator() {
  }

  public static long generateId() {
    return ++counter;
  }
}