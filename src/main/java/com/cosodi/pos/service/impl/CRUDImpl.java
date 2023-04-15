package com.cosodi.pos.service.impl;

import com.cosodi.pos.exception.ModelNotFoundException;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.service.ICRUDService;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUDService<T, ID> {

    protected abstract IGenericRepository<T, ID> getRepository();

    @Override
    public List<T> findAll() {
        return this.getRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        return this.getRepository().findById(id).orElse(null);
    }

    @Override
    public T save(T t) {
        return this.getRepository().save(t);
    }

    @Override
    public T update(ID id, T t) {
        this.getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
        return this.getRepository().save(t);
    }

    @Override
    public void deleteById(ID id) {
        this.getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND " + id));
        this.getRepository().deleteById(id);
    }
}
