package com.evidence.app.services;

import com.evidence.app.entities.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * The interface Operations service.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
public interface OperationsService {

    /**
     * Create detective entity from person details and rank.
     *
     * @param firstName  the first name
     * @param lastName   the last name
     * @param hiringDate the hiring date
     * @param rank       the rank
     * @return the detective
     */
    Detective createDetective(String firstName, String lastName, LocalDateTime hiringDate, Rank rank);

    /**
     * Create criminal case.
     *
     * @param caseType             the case type
     * @param shortDescription     the short description
     * @param badgeNo              the badge no
     * @param evidenceAndLocations the evidence and locations
     * @return the criminal case
     */
    CriminalCase createCriminalCase(CaseType caseType, String shortDescription, String badgeNo, Map<Evidence, String> evidenceAndLocations);

    /**
     * Assign lead investigator optional.
     *
     * @param caseNumber           the case number
     * @param leadDetectiveBadgeNo the lead detective badge no
     * @return the optional
     */
    Optional<CriminalCase> assignLeadInvestigator(String caseNumber, String leadDetectiveBadgeNo);

    /**
     * Link evidence optional.
     *
     * @param caseNumber   the case number
     * @param evidenceList the evidence list
     * @return the optional
     */
    Optional<CriminalCase> linkEvidence(String caseNumber, List<Evidence> evidenceList);

    /**
     * Solve case boolean.
     *
     * @param caseNumber the case number
     * @param reason     the reason
     * @return the boolean
     */
    boolean solveCase(String caseNumber, String reason);

    /**
     * Gets assigned team.
     *
     * @param caseNumber the case number
     * @return the assigned team
     */
    Set<Detective> getAssignedTeam(String caseNumber);
}
