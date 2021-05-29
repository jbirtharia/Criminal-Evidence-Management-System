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

import com.evidence.app.entities.CriminalCase;
import com.evidence.app.entities.Evidence;
import com.evidence.app.entities.Storage;
import com.evidence.app.repos.EvidenceRepo;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author JayendraB
 * @createdOn 5/16/2021
 */
public class StubEvidenceRepo extends StubAbstractRepo<Evidence> implements EvidenceRepo {

    @Override
    public <S extends Evidence> S save(S s) {
        if (s.getId() == null) {
            long id = (long) records.size() + 1;
            s.setId(id);
        }
        records.put(s.getId(), s);
        return s;
    }

    @Override
    public Set<Evidence> findByCriminalCase(CriminalCase criminalCase) {
        throw new NotImplementedException("Not needed for this stub.");
    }

    @Override
    public Evidence findByNumber(String evidenceNumber) {
        throw new NotImplementedException("Not needed for this stub.");
    }

    @Override
    public List<Evidence> findAllByStorage(Storage storage) {
        return null;
    }

    @Override
    public List<Evidence> findAll() {
        return null;
    }

    @Override
    public List<Evidence> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Evidence> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Evidence> findAllById(Iterable<Long> iterable) {
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
    public void delete(Evidence evidence) {

    }

    @Override
    public void deleteAll(Iterable<? extends Evidence> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Evidence> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Evidence> findById(Long aLong) {
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
    public <S extends Evidence> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Evidence> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Evidence getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Evidence> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Evidence> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Evidence> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Evidence> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Evidence> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Evidence> boolean exists(Example<S> example) {
        return false;
    }
}
