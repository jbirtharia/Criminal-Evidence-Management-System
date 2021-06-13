package com.evidence.app.services;

import com.evidence.app.entities.Storage;

/**
 * The interface Storage service.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
public interface StorageService extends AbstractService<Storage>{
    /**
     * Create storage entity from name and location.
     *
     * @param name     the name
     * @param location the location
     * @return the storage
     */
    Storage createStorage(String name, String location);

    /**
     * Gets evidence storage.
     *
     * @param name the name
     * @return the evidence storage
     */
    Storage getEvidenceStorage(String name);
}
