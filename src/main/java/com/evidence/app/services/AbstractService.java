package com.evidence.app.services;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public interface AbstractService<T> {

    void save(T entity);

    T findById(Long entityId);

    void delete(T entity);

    int deleteById(Long entityId);
}
