package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.DocumentType;
import com.cosodi.pos.repository.IDocumentTypeRepository;
import com.cosodi.pos.repository.IGenericRepository;
import com.cosodi.pos.service.IDocumentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl extends CRUDImpl<DocumentType, Integer> implements IDocumentTypeService {
    private final IDocumentTypeRepository iDocumentTypeRepository;

    @Override
    protected IGenericRepository<DocumentType, Integer> getRepository() {
        return this.iDocumentTypeRepository;
    }
}
