package com.cosodi.pos.controller;

import com.cosodi.pos.dto.DocumentTypeDTO;
import com.cosodi.pos.entity.DocumentType;
import com.cosodi.pos.service.IDocumentTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/document-types")
@RequiredArgsConstructor
public class DocumentTypeController {

    private final IDocumentTypeService iDocumentTypeService;

    @Qualifier("documentTypeMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DocumentTypeDTO>> findAll() {
        List<DocumentTypeDTO> documentTypeDTOList = this.iDocumentTypeService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(documentTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentTypeDTO> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.convertToDTO(this.iDocumentTypeService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DocumentTypeDTO> save(@Valid @RequestBody DocumentTypeDTO documentTypeDTO) {
        DocumentType createdDocumentType = this.iDocumentTypeService.save(this.convertToEntity(documentTypeDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDocumentType.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentTypeDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody DocumentTypeDTO documentTypeDTO) {
        documentTypeDTO.setDocumentTypeId(id);
        return new ResponseEntity<>(this.convertToDTO(this.iDocumentTypeService.update(this.convertToEntity(documentTypeDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        this.iDocumentTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private DocumentTypeDTO convertToDTO(DocumentType documentType) {
        return this.modelMapper.map(documentType, DocumentTypeDTO.class);
    }

    private DocumentType convertToEntity(DocumentTypeDTO dto) {
        return this.modelMapper.map(dto, DocumentType.class);
    }
}
