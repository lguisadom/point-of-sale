package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.Sale;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.repository.ISaleRepository;
import com.cosodi.pos.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl extends CRUDImpl<Sale, Long> implements ISaleService {
    private final ISaleRepository iSaleRepository;

    @Override
    protected IGenericRepository<Sale, Long> getRepository() {
        return this.iSaleRepository;
    }

    /*@Override
    @Transactional
    public Sale saveTransactional(Sale sale) {
        return this.iSaleRepository.save(sale);
    }*/
}
