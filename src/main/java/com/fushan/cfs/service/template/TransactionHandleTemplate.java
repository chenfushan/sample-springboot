package com.fushan.cfs.service.template;

import com.fushan.cfs.component.model.TransactionResult;

/**
 * Created by alps on 2019/1/6.
 */
public interface TransactionHandleTemplate {

    void execute(TransactionResult result, TransactionTemplateCallback callback);

    void executeInNewTransaction(TransactionResult result, TransactionTemplateCallback callback);

    void executeWithoutTransaction(TransactionResult result, TransactionTemplateCallback callback);
}
