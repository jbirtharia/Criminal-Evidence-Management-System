package com.evidence.app.services;

import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Person;
import com.evidence.app.entities.Rank;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public interface DetectiveService extends  AbstractService<Detective> {
    Detective createDetective(Person person, Rank rank);
}
