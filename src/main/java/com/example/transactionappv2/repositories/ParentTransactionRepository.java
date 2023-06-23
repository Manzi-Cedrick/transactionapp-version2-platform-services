package com.example.transactionappv2.repositories;

import com.example.transactionappv2.models.ParentTransaction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Repository
public class ParentTransactionRepository implements JpaRepository<ParentTransaction, UUID> {
    public Optional<ParentTransaction> findById() {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ParentTransaction> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ParentTransaction> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ParentTransaction> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ParentTransaction getOne(UUID uuid) {
        return null;
    }

    @Override
    public ParentTransaction getById(UUID uuid) {
        return null;
    }

    @Override
    public ParentTransaction getReferenceById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends ParentTransaction> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ParentTransaction> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ParentTransaction> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ParentTransaction> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ParentTransaction> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ParentTransaction> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ParentTransaction, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ParentTransaction> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ParentTransaction> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ParentTransaction> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<ParentTransaction> findAll() {
        return null;
    }

    @Override
    public List<ParentTransaction> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(ParentTransaction entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends ParentTransaction> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ParentTransaction> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ParentTransaction> findAll(Pageable pageable) {
        return null;
    }
}
