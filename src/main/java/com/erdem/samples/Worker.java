package com.erdem.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by bilginc_user on 15.06.2017.
 */
public class Worker {

    private static final Logger LOGGER = LoggerFactory.getLogger(Worker.class);

    public Worker() {
        LOGGER.info("Created worker {}", System.identityHashCode(this));
    }

    //Major task is done here.
    public void doWork(){
        int j=0;
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            j++;
        }

    }
}
