package com.evidence.app.services.impl;

import com.evidence.app.entities.AbstractEntity;
import com.evidence.app.services.AbstractService;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public class SimpleAbstractService <T extends AbstractEntity>  implements AbstractService<T> {


    @Override
    public void save(T entity) {

    }

    @Override
    public T findById(Long entityId) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public int deleteById(Long entityId) {
        return 0;
    }

}
