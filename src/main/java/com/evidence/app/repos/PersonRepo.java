package com.evidence.app.repos;

import com.evidence.app.entities.Person;

import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public interface PersonRepo extends AbstractRepo<Person>{

    Person findByUsername(String username);

    Set<Person> findByCompleteName(String firstName, String lastName);
}
