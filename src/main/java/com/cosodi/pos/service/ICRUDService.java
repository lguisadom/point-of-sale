package com.cosodi.pos.service;

import java.util.List;

public interface ICRUDService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    T update(ID id, T t);
    void deleteById(ID id);
}
