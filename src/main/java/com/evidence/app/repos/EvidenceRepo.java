package com.evidence.app.repos;

import com.evidence.app.entities.CriminalCase;
import com.evidence.app.entities.Evidence;
import com.evidence.app.entities.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface EvidenceRepo extends JpaRepository<Evidence,Long> {

    Set<Evidence> findByCriminalCase(CriminalCase criminalCase);

    Evidence findByNumber(String evidenceNumber);

    List<Evidence> findAllByStorage(Storage storage);
}
