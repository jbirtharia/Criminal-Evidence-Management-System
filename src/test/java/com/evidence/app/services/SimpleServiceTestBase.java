package com.evidence.app.services;

import com.evidence.app.repos.CriminalCaseRepo;
import com.evidence.app.repos.DetectiveRepo;
import com.evidence.app.repos.EvidenceRepo;
import com.evidence.app.repos.StorageRepo;
import com.evidence.app.repos.stub.StubCriminalCaseRepo;
import com.evidence.app.repos.stub.StubDetectiveRepo;
import com.evidence.app.repos.stub.StubEvidenceRepo;
import com.evidence.app.repos.stub.StubStorageRepo;
import com.evidence.app.services.impl.SimpleDetectiveService;
import com.evidence.app.services.impl.SimpleOperationsService;
import com.evidence.app.services.impl.SimpleStorageService;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public class SimpleServiceTestBase {

    DetectiveRepo detectiveRepo;
    CriminalCaseRepo criminalCaseRepo;
    EvidenceRepo evidenceRepo;
    StorageRepo storageRepo;

    OperationsService operationsService;
    DetectiveService detectiveService;
    SimpleStorageService storageService;

    /**
     * Init method.
     * Create all objects for test cases and inject dependencies.
     */
    void init() {
        this.detectiveRepo = new StubDetectiveRepo();
        this.criminalCaseRepo = new StubCriminalCaseRepo();
        this.evidenceRepo = new StubEvidenceRepo();
        this.storageRepo = new StubStorageRepo();

        this.detectiveService = new SimpleDetectiveService(detectiveRepo);
        this.storageService = new SimpleStorageService(storageRepo);
        this.operationsService = new SimpleOperationsService(detectiveService,storageService,criminalCaseRepo);
    }
}
