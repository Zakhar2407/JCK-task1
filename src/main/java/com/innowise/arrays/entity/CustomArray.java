package com.innowise.arrays.entity;

import com.innowise.arrays.observer.ArrayObserver;
import com.innowise.arrays.util.IdGenerator;

import java.util.Arrays;

public class CustomArray extends AbstractArrayStructure {
    private int[] elements;
    private ArrayObserver observer;

    public long getId() {
        return id;
    }

    // Default constructor
    public CustomArray() {
        super();
        this.elements = new int[0];
    }

    // Constructor with parameters
    public CustomArray(int[] elements) {
        this.id = IdGenerator.generateId();
        this.elements = elements.clone();
    }

    //Getter
    public int[] getElements() {
        return this.elements.clone();
    }

    //Setter
    public void setElements(int[] elements) {
        this.elements = elements.clone();
        notifyObserver();
    }

    public void setObserver(ArrayObserver observer) {
        this.observer = observer;
    }

    private void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomArray)) {
            return false;
        }
        CustomArray customArray = (CustomArray) o;
        return id == customArray.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("elements=").append(Arrays.toString(elements));
        sb.append('}');
        return sb.toString();
    }
}
