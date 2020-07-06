package com.phodal.pepper.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogClassA {
    private static Logger logger = LoggerFactory.getLogger(LogClassA.class);

    public void log() {
        logger.warn("yup");
    }
}
