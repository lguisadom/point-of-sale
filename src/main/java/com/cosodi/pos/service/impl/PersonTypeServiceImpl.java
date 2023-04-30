package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.PersonType;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.repository.IPersonTypeRepository;
import com.cosodi.pos.service.IPersonTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonTypeServiceImpl extends CRUDImpl<PersonType, Integer> implements IPersonTypeService {
    private final IPersonTypeRepository iPersonTypeRepository;
    @Override
    protected IGenericRepository<PersonType, Integer> getRepository() {
        return this.iPersonTypeRepository;
    }
}
