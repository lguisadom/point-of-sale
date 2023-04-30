package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.Department;
import com.cosodi.pos.repository.IDepartamentRepository;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl extends CRUDImpl<Department, Long> implements IDepartmentService {
    private final IDepartamentRepository iDepartamentRepository;

    @Override
    protected IGenericRepository<Department, Long> getRepository() {
        return this.iDepartamentRepository;
    }
}
