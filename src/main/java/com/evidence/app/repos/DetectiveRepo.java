package com.evidence.app.repos;

import com.evidence.app.entities.Detective;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
@Repository
public interface DetectiveRepo extends JpaRepository<Detective, Long> {

    Optional<Detective> findByBadgeNumber(String badgeNumber);

    @EntityGraph(attributePaths = {"criminalCases"})
    @Query("select d from Detective d where d.id=:id" )
    Optional<Detective> findByIdWithCriminalCases(@Param("id") Long id);
}
