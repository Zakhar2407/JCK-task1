package com.innowise.jck.arrays.entity;

import java.util.Arrays;

public class CustomArray extends AbstractArrayStructure {
    private int[] elements;

    // Default constructor
    public CustomArray() {
        super();
        this.elements = new int[0];
    }

    // Constructor with parameters
    public CustomArray(int[] elements) {
        super();
        if (elements == null) {
            this.elements = new int[0];
        } else {
            this.elements = elements.clone();
        }
    }

    //Getter
    public int[] getElements() {
        return this.elements.clone();
    }

    //Setter
    public void setElements(int[] elements) {
        if (elements == null) {
            this.elements = new int[0];
        } else {
            this.elements = elements.clone();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        return Arrays.equals(this.elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
