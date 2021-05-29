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
import com.evidence.app.repos.DetectiveRepo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public class StubDetectiveRepo extends StubAbstractRepo<Detective> implements DetectiveRepo {

    @Override
    public Optional<Detective> findByBadgeNumber(String badgeNumber) {
        return Optional.of(records.get(1L));
    }

    @Override
    public Optional<Detective> findByIdWithCriminalCases(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Detective> findAll() {
        return null;
    }

    @Override
    public List<Detective> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Detective> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Detective> findAllById(Iterable<Long> iterable) {
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
    public void delete(Detective detective) {

    }

    @Override
    public void deleteAll(Iterable<? extends Detective> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Detective> S save(S s) {
        if (s.getId() == null) {
           long id = (long) records.size() + 1;
            s.setId(id);
        }
        records.put(s.getId(), s);
        return s;
    }

    @Override
    public <S extends Detective> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Detective> findById(Long aLong) {
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
    public <S extends Detective> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Detective> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Detective getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Detective> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Detective> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Detective> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Detective> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Detective> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Detective> boolean exists(Example<S> example) {
        return false;
    }
}
