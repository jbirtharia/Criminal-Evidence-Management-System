package com.evidence.app.services.impl;

import com.evidence.app.contants.Constants;
import com.evidence.app.entities.*;
import com.evidence.app.repos.CriminalCaseRepo;
import com.evidence.app.services.DetectiveService;
import com.evidence.app.services.OperationsService;
import com.evidence.app.services.StorageService;
import com.evidence.app.util.NumberGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * The type Simple operations service.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
@Service
@Data
@NoArgsConstructor
public class SimpleOperationsService implements OperationsService {

    @Autowired
    private CriminalCaseRepo criminalCaseRepo;

    @Autowired
    private DetectiveService detectiveService;

    @Autowired
    private StorageService storageService;

    @Override
    public Detective createDetective(String firstName, String lastName, LocalDateTime hiringDate, Rank rank) {
        throw new NotImplementedException(Constants.NOT_NEEDED_EXCEPTION);
    }

    @Override
    public CriminalCase createCriminalCase(CaseType caseType, String shortDescription, String badgeNo, Map<Evidence, String> evidenceMap) {
        Set<Evidence> evidences = new LinkedHashSet<>();

        // Retrieve detective
        Detective detective = detectiveService.getDetectiveForCase(badgeNo);

        // Create a criminal case instance
        CriminalCase criminalCase = new CriminalCase();

        // Set the leadDetective field only when detective is present
        Optional.ofNullable(detective)
                .ifPresent(criminalCase::setLeadInvestigator);

        evidenceMap.forEach((evidence, storageName) -> {
            // Retrieve storage, throw ServiceException if not found
            Storage storage = storageService.getEvidenceStorage(storageName);

            // If storage is found, link it to the evidence and add evidence to the case
            evidence.setStorage(storage);
            evidence.setCriminalCase(criminalCase);
            evidences.add(evidence);
        });

        criminalCase.setShortDescription(shortDescription);
        criminalCase.setType(caseType);
        if (CollectionUtils.isNotEmpty(evidences))
            criminalCase.setEvidenceSet(evidences);

        criminalCase.setNumber(NumberGenerator.getCaseNumber());
        // Save the criminal case instance
        criminalCaseRepo.save(criminalCase);
        return criminalCase;
    }

    @Override
    public Optional<CriminalCase> assignLeadInvestigator(String caseNumber, String leadDetectiveBadgeNo) {
        throw new NotImplementedException(Constants.NOT_NEEDED_EXCEPTION);
    }

    @Override
    public Optional<CriminalCase> linkEvidence(String caseNumber, List<Evidence> evidenceList) {
        throw new NotImplementedException(Constants.NOT_NEEDED_EXCEPTION);
    }

    @Override
    public boolean solveCase(String caseNumber, String reason) {
        throw new NotImplementedException(Constants.NOT_NEEDED_EXCEPTION);
    }

    @Override
    public Set<Detective> getAssignedTeam(String caseNumber) {
        throw new NotImplementedException(Constants.NOT_NEEDED_EXCEPTION);
    }

    public SimpleOperationsService(DetectiveService detectiveService, StorageService storageService, CriminalCaseRepo criminalCaseRepo){
        this.detectiveService = detectiveService;
        this.storageService = storageService;
        this.criminalCaseRepo = criminalCaseRepo;
    }
}
