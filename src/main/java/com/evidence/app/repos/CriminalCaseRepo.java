package com.evidence.app.repos;

import com.evidence.app.entities.CriminalCase;
import com.evidence.app.entities.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * The interface Criminal case repo.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
@Repository
public interface CriminalCaseRepo extends  JpaRepository<CriminalCase, Long> {

    /**
     * Find by lead investigator set.
     *
     * @param detective the detective
     * @return the set
     */
    Set<CriminalCase> findByLeadInvestigator(Detective detective);

    /**
     * Find by number optional.
     *
     * @param caseNumber the case number
     * @return the optional
     */
    Optional<CriminalCase> findByNumber(String caseNumber);

}
