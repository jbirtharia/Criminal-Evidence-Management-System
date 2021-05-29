/*
Freeware License, some rights reserved

Copyright (c) 2019 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.evidence.app.repos.stub;

import com.evidence.app.entities.Detective;
import com.evidence.app.entities.Person;
import com.evidence.app.repos.PersonRepo;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public class StubPersonRepo extends StubAbstractRepo<Person> implements PersonRepo {

    @Override
    public <S extends Person> S save(S s) {
        if (s.getId() == null) {
            long id = (long) records.size() + 1;
            s.setId(id);
        }
        records.put(s.getId(), s);
        return s;
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<Person> findByUsernameLike(String username) {
        return null;
    }

    @Override
    public Optional<Person> findByCompleteName(String fn, String lastName) {
        return Optional.empty();
    }


    @Override
    public List<Person> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Person> findByFirstNameLike(String firstName) {
        return null;
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Person> findByLastNameLike(String lastName) {
        return null;
    }

    @Override
    public List<Person> findByHiringDate(LocalDateTime date) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public List<Person> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Person> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public void deleteAll(Iterable<? extends Person> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Person> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Person> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Person> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Person> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Person getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Person> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Person> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Person> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Person> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Person> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Person> boolean exists(Example<S> example) {
        return false;
    }
}
