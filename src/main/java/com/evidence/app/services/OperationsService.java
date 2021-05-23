package com.evidence.app.services;

import com.evidence.app.entities.*;
import com.evidence.app.repos.CriminalCaseRepo;
import com.evidence.app.repos.DetectiveRepo;
import com.evidence.app.repos.EvidenceRepo;
import com.evidence.app.repos.StorageRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public interface OperationsService {

    Detective createDetective(String firstName, String lastName, LocalDateTime hiringDate, Rank rank);

    CriminalCase createCriminalCase(CaseType caseType, String shortDescription, String badgeNo, Map<Evidence, String> evidenceAndLocations);

    Optional<CriminalCase> assignLeadInvestigator(String caseNumber, String leadDetectiveBadgeNo);

    Optional<CriminalCase> linkEvidence(String caseNumber, List<Evidence> evidenceList);

    boolean solveCase(String caseNumber, String reason);

    Set<Detective> getAssignedTeam(String caseNumber);

    // setter skeletons for setting repositories

    void setCriminalCaseRepo(CriminalCaseRepo criminalCaseRepo);

    void setEvidenceRepo(EvidenceRepo evidenceRepo);

    void setDetectiveRepo(DetectiveRepo detectiveRepo);

    void setStorageRepo(StorageRepo storageRepo);
}
