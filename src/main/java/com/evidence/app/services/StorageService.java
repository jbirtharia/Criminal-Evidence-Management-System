package com.evidence.app.services;

import com.evidence.app.entities.Storage;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public interface StorageService extends AbstractService<Storage>{
    Storage createStorage(String name, String location);

    Storage getEvidenceStorage(String name);
}
