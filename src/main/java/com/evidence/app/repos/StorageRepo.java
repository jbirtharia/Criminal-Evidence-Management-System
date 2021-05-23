package com.evidence.app.repos;

import com.evidence.app.entities.Storage;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface StorageRepo extends AbstractRepo<Storage>{

    Optional<Storage> findByName(String name);

    Optional<Storage> findByLocation(String location);
}
