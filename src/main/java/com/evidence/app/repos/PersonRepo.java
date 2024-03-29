package com.evidence.app.repos;

import com.evidence.app.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.username=:un")
    Optional<Person> findByUsername(@Param("un")String username);

    @Query("select p from Person p where p.username like %?1%")
    List<Person> findByUsernameLike(String username);

    @Query("select p from Person p where p.firstName=:fn and p.lastName=:ln")
    Optional<Person> findByCompleteName(@Param("fn")String fn, @Param("ln")String lastName);

    @Query("select p from Person p where p.firstName=:fn")
    List<Person> findByFirstName(@Param("fn")String firstName);

    @Query("select p from Person p where p.firstName like %?1%")
    List<Person> findByFirstNameLike(String firstName);

    @Query("select p from Person p where p.lastName=:ln")
    List<Person> findByLastName( @Param("ln")String lastName);

    @Query("select p from Person p where p.lastName like %?1%")
    List<Person> findByLastNameLike(String lastName);

    @Query("select p from Person p where p.hiringDate=:hd")
    List<Person> findByHiringDate(@Param("hd") LocalDateTime date);
}
