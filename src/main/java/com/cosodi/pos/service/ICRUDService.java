package com.cosodi.pos.service;

import java.util.List;

public interface ICRUDService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T t);
    T update(T t, ID id);
    void deleteById(ID id);
}
