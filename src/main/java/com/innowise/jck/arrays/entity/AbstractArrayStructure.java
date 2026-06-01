package com.innowise.jck.arrays.entity;

//Base abstract class for custom mathematical structures.

public abstract class AbstractArrayStructure {

    // Default constructor
    protected AbstractArrayStructure() {
    }

    // Abstract method that forces subclasses to provide text representation
    @Override
    public abstract String toString();
}
