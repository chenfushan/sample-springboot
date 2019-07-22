package com.fushan.cfs.service.template;

/**
 * Created by alps on 2019/1/6.
 */
public interface TransactionTemplateCallback {
    /**
     * check legal
     */
    void check();

    /**
     * do transaction process
     */
    void doProcess() throws Exception;

    /**
     * do after
     */
    void complete();
}
