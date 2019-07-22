package com.fushan.cfs.component.model;

/**
 * Created by alps on 2019/1/6.
 */
public class Result<T> {
    /** is success */
    private boolean success;
    /** result */
    private T value;
    /** error msg */
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
