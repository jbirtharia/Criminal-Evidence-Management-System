package com.evidence.app.repos;

import com.evidence.app.entities.CriminalCase;
import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Evidence;
import com.evidence.app.entities.Storage;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface EvidenceRepo extends AbstractRepo<Evidence> {

    Set<Evidence> findByCriminalCase(CriminalCase criminalCase);

    Evidence findByNumber(String evidenceNumber);

    boolean isInStorage(Storage storage);
}
