package com.innowise.arrays.factory.impl;

import com.innowise.arrays.entity.CustomArray;
import com.innowise.arrays.factory.CustomArrayFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    //Initialization of Log4j2
    private static final Logger logger = LogManager.getLogger(CustomArrayFactoryImpl.class);
    //Default constructor
    public CustomArrayFactoryImpl() {
    }

    //Implementation
    @Override
    public CustomArray createCustomArray(int[] elements) {
        CustomArray customArray = new CustomArray();
        logger.info("Object has created");
        return customArray;
    }
}
