package com.innowise.jck.arrays.factory.impl;

import com.innowise.jck.arrays.entity.CustomArray;
import com.innowise.jck.arrays.factory.CustomArrayFactory;
import org.apache.logging.log4j.LogManager;
import java.util.logging.Logger;

public class CustomArrayFactoryImpl implements CustomArrayFactory {

    //Initialization of Log4j2
    private static final Logger logger = (Logger) LogManager.getLogger(CustomArrayFactoryImpl.class);
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
