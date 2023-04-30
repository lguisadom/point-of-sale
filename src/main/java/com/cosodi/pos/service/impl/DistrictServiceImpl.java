package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.District;
import com.cosodi.pos.repository.IDistrictRepository;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.service.IDistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl extends CRUDImpl<District, Long> implements IDistrictService {
    private final IDistrictRepository iDistrictRepository;


    @Override
    protected IGenericRepository<District, Long> getRepository() {
        return this.iDistrictRepository;
    }
}
