package com.cosodi.pos.controller;

import com.cosodi.pos.dto.PersonTypeDTO;
import com.cosodi.pos.entity.PersonType;
import com.cosodi.pos.service.IPersonTypeService;
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
@RequestMapping("/api/v1/person-types")
@RequiredArgsConstructor
public class PersonTypeController {

    private final IPersonTypeService iPersonTypeService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PersonTypeDTO>> findAll() {
        List<PersonTypeDTO> personTypeDTOList = this.iPersonTypeService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(personTypeDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonTypeDTO> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.convertToDTO(this.iPersonTypeService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PersonTypeDTO personTypeDTO) {
        PersonType createdPersonType = this.iPersonTypeService.save(this.convertToEntity(personTypeDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPersonType.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonTypeDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody PersonTypeDTO personTypeDTO) {
        personTypeDTO.setId(id);
        return new ResponseEntity<>(this.convertToDTO(this.iPersonTypeService.update(this.convertToEntity(personTypeDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        this.iPersonTypeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public PersonTypeDTO convertToDTO(PersonType personType) {
        return modelMapper.map(personType, PersonTypeDTO.class);
    }

    public PersonType convertToEntity(PersonTypeDTO personTypeDTO) {
        return modelMapper.map(personTypeDTO, PersonType.class);
    }
}
