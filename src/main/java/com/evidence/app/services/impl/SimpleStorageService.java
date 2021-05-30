package com.evidence.app.services.impl;

import com.evidence.app.contants.Constants;
import com.evidence.app.custom.exception.ServiceException;
import com.evidence.app.entities.Storage;
import com.evidence.app.repos.StorageRepo;
import com.evidence.app.services.StorageService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Service
@NoArgsConstructor
public class SimpleStorageService extends SimpleAbstractService<Storage> implements StorageService {

    @Autowired
    private StorageRepo repo;

    @Override
    public Storage createStorage(String name, String location) {
        Storage storage = new Storage();
        storage.setName(name);
        storage.setLocation(location);
        repo.save(storage);
        return storage;
    }

    @Override
    public Storage getEvidenceStorage(String name) {
        return repo.findByName(name).orElseThrow(() -> new ServiceException(Constants.STORE_NOT_FOUND));
    }

    public SimpleStorageService(StorageRepo repo){
        this.repo = repo;
    }
}
