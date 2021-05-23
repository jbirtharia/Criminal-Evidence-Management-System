package com.evidence.app.repos;

import com.evidence.app.entities.AbstractEntity;
import org.springframework.stereotype.Repository;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface AbstractRepo <T extends AbstractEntity>{

    void save(T entity);

    void delete(T entity);

    int deleteById(Long entityId);

    T findById(Long entityId);
}
