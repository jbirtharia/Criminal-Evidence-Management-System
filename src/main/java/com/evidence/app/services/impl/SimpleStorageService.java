package com.evidence.app.services.impl;

import com.evidence.app.entities.Storage;
import com.evidence.app.repos.StorageRepo;
import com.evidence.app.services.StorageService;
import org.springframework.stereotype.Service;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Service
public class SimpleStorageService extends SimpleAbstractService<Storage> implements StorageService {

    private StorageRepo repo;

    @Override
    public Storage createStorage(String name, String location) {
        Storage storage = new Storage();
        storage.setName(name);
        storage.setLocation(location);
        repo.save(storage);
        return storage;
    }

    public void setRepo(StorageRepo repo) {
        this.repo = repo;
    }
}
