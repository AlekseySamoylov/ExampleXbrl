package com.apline.alekseysamoylov.example;

import com.sleepycat.db.Environment;
import com.sleepycat.db.ErrorHandler;
import org.apache.log4j.Logger;

/**
 * Created by asamoilov on 03.08.2016.
 */
public class MyErrorHandler implements ErrorHandler {
    private final Logger LOGGER = Logger.getLogger(MyErrorHandler.class);

    public void error(Environment env,
                      String errpfx,
                      String msg) {
        LOGGER.warn(errpfx + " : " + msg);
    }
}
