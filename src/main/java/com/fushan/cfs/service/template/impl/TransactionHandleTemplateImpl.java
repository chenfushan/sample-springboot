package com.fushan.cfs.service.template.impl;

import com.fushan.cfs.component.model.TransactionResult;
import com.fushan.cfs.service.template.TransactionHandleTemplate;
import com.fushan.cfs.service.template.TransactionTemplateCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * transaction control class
 * Created by alps on 2019/1/7.
 */
@Service("transactionHandleTemplate")
public class TransactionHandleTemplateImpl implements TransactionHandleTemplate, InitializingBean{

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionHandleTemplateImpl.class);

    private TransactionTemplate transactionTemplate = new TransactionTemplate();

    private TransactionTemplate newTransactionTemplate = new TransactionTemplate();

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        transactionTemplate.setTransactionManager(platformTransactionManager);
        newTransactionTemplate.setTransactionManager(platformTransactionManager);
    }

    @Override
    public void execute(TransactionResult result, TransactionTemplateCallback callback) {
        transactionTemplate.execute((status) -> {
            try {
                callback.check();
                callback.doProcess();
                result.setSuccess(true);
            } catch (Exception e) {
                status.setRollbackOnly();
                result.setSuccess(false);
                LOGGER.error("", e);
            }finally {
                callback.complete();
            }
            return result;
        });
    }

    @Override
    public void executeInNewTransaction(TransactionResult result, TransactionTemplateCallback callback) {
        newTransactionTemplate.execute(status -> {
            try {
                callback.check();
                callback.doProcess();
            } catch (Exception e) {
                status.setRollbackOnly();
                result.setSuccess(false);
                LOGGER.error("",e);
            }finally {
                callback.complete();
            }
            return result;
        });
    }

    @Override
    public void executeWithoutTransaction(TransactionResult result, TransactionTemplateCallback callback) {
        try {
            callback.check();
            callback.doProcess();
        } catch (Exception e) {
            result.setSuccess(false);
            LOGGER.error("",e);
        }finally {
            callback.complete();
        }
    }
}
