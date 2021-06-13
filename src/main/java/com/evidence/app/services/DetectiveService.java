package com.evidence.app.services;

import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Person;
import com.evidence.app.entities.Rank;

/**
 * The interface Detective service.
 *
 * @author JayendraB
 * @createdOn 5 /16/2021
 */
public interface DetectiveService extends  AbstractService<Detective> {
    /**
     * Create detective entity with the help of person and rank entity.
     *
     * @param person the person
     * @param rank   the rank
     * @return the detective
     */
    Detective createDetective(Person person, Rank rank);

    /**
     * Gets detective for case.
     *
     * @param badgeNumber the badge number
     * @return the detective for case
     */
    Detective getDetectiveForCase(String badgeNumber);
}
