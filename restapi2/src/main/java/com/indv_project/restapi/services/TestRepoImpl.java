//package com.indv_project.restapi.services;
//
//import com.indv_project.restapi.models.Item;
//import com.indv_project.restapi.controllers.TestRepository;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TestRepoImpl implements TestRepository {
//    @Override
//    public Boolean findItemByBody(String body) {
//        return null;
//    }
//
//    @Override
//    public List<Item> findAll() {
//        return null;
//    }
//
//    @Override
//    public List<Item> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Item> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<Item> findAllById(Iterable<Integer> integers) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(Item entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Item> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Item> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Item> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<Item> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Item> S saveAndFlush(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Item> List<S> saveAllAndFlush(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public void deleteAllInBatch(Iterable<Item> entities) {
//
//    }
//
//    @Override
//    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Item getOne(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public Item getById(Integer integer) {
//        return null;
//    }
//
//    @Override
//    public <S extends Item> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Item> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Item> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Item> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Item> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Item> boolean exists(Example<S> example) {
//        return false;
//    }
//}
