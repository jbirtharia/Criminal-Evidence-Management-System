package com.evidence.app.repos;

import com.evidence.app.entities.CriminalCase;
import com.evidence.app.entities.Detective;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface CriminalCaseRepo extends  AbstractRepo<CriminalCase>{

    Set<CriminalCase> findByLeadInvestigator(Detective detective);

    Optional<CriminalCase> findByNumber(String caseNumber);
}
