package com.evidence.app.repos;

import com.evidence.app.entities.Detective;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface DetectiveRepo extends AbstractRepo<Detective>{

    Optional<Detective> findByBadgeNumber(String badgeNumber);
}
