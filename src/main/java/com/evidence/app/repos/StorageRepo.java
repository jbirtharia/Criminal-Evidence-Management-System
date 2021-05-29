package com.evidence.app.repos;

import com.evidence.app.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface StorageRepo extends JpaRepository<Storage, Long> {

    Optional<Storage> findByName(String name);

    Optional<Storage> findByLocation(String location);
}
