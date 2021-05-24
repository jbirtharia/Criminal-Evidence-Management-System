package com.evidence.app.services.impl;

import com.evidence.app.contants.Constants;
import com.evidence.app.custom.exception.ServiceException;
import com.evidence.app.entities.*;
import com.evidence.app.repos.CriminalCaseRepo;
import com.evidence.app.repos.DetectiveRepo;
import com.evidence.app.repos.EvidenceRepo;
import com.evidence.app.repos.StorageRepo;
import com.evidence.app.services.OperationsService;
import lombok.Data;
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
public class SimpleOperationsService implements OperationsService {

    @Autowired
    private CriminalCaseRepo criminalCaseRepo;

    @Autowired
    private EvidenceRepo evidenceRepo;

    @Autowired
    private DetectiveRepo detectiveRepo;

    @Autowired
    private StorageRepo storageRepo;

    @Override
    public Detective createDetective(String firstName, String lastName, LocalDateTime hiringDate, Rank rank) {
        throw new NotImplementedException(Constants.NOT_NEEDED_EXCEPTION);
    }

    @Override
    public CriminalCase createCriminalCase(CaseType caseType, String shortDescription, String badgeNo, Map<Evidence, String> evidenceMap) {
        Set<Evidence> evidences = new LinkedHashSet<>();

        // Retrieve detective
        Optional<Detective> isDetective = detectiveRepo.findByBadgeNumber(badgeNo);

        // Create a criminal case instance
        CriminalCase criminalCase = new CriminalCase();

        // Set the leadDetective field only when detective is present
        isDetective.ifPresent(criminalCase::setLeadInvestigator);

        evidenceMap.forEach((evidence, storageName) -> {
            // Retrieve storage, throw ServiceException if not found
            Optional<Storage> isStorage = storageRepo.findByName(storageName);

            // If storage is found, link it to the evidence and add evidence to the case
            isStorage.ifPresentOrElse(
                    storage -> {
                        evidence.setStorage(storage);
                        evidences.add(evidence);
                    },
                    () -> {
                        throw new ServiceException(Constants.STORE_NOT_FOUND);
                    });
        });

        criminalCase.setShortDescription(shortDescription);
        criminalCase.setType(caseType);
        if (CollectionUtils.isNotEmpty(evidences))
            criminalCase.setEvidenceSet(evidences);

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
}
