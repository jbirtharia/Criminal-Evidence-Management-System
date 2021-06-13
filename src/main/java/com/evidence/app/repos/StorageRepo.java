package com.evidence.app.repos;

import com.evidence.app.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Storage repo.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
@Repository
public interface StorageRepo extends JpaRepository<Storage, Long> {

    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Storage> findByName(String name);

    /**
     * Find by location optional.
     *
     * @param location the location
     * @return the optional
     */
    Optional<Storage> findByLocation(String location);
}
