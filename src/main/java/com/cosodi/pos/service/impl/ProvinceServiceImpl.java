package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.Province;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.repository.IProvinceRepository;
import com.cosodi.pos.service.IProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl extends CRUDImpl<Province, Long> implements IProvinceService {
    private final IProvinceRepository iProvinceRepository;

    @Override
    protected IGenericRepository<Province, Long> getRepository() {
        return this.iProvinceRepository;
    }
}
