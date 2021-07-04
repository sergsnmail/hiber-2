package com.sergsnmail.hiber2.repository;

public interface EntityCRUD <T> {
    void create(T entity);
    T get(Class<T> cls, Long id);
    void update(T entity);
    void delete(T entity);
}
