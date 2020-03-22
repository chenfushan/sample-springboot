package com.fushan.cfs.common.exception;

/**
 * Created by alps on 2020/1/18.
 */
public class SampleException extends RuntimeException {
    public SampleException(){
        super();
    }

    public SampleException(String message) {
        super(message);
    }

    public SampleException(String message, Throwable cause) {
        super(message, cause);
    }
}
