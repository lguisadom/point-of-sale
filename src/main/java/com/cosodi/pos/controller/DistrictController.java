package com.cosodi.pos.controller;

import com.cosodi.pos.dto.DistrictDTO;
import com.cosodi.pos.entity.District;
import com.cosodi.pos.service.IDistrictService;
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
@RequestMapping("/api/v1/districts")
@RequiredArgsConstructor
public class DistrictController {

    private final IDistrictService iDistrictService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DistrictDTO>> findAll() {
        List<DistrictDTO> districtDTOList = this.iDistrictService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(districtDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.convertToDTO(this.iDistrictService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DistrictDTO districtDTO) {
        District createdDistrict = this.iDistrictService.save(this.convertToEntity(districtDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDistrict.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictDTO> update(@PathVariable("id") Long id, @Valid @RequestBody DistrictDTO districtDTO) {
        districtDTO.setId(id);
        return new ResponseEntity<>(this.convertToDTO(this.iDistrictService.update(this.convertToEntity(districtDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.iDistrictService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public DistrictDTO convertToDTO(District district) {
        return modelMapper.map(district, DistrictDTO.class);
    }

    public District convertToEntity(DistrictDTO districtDTO) {
        return modelMapper.map(districtDTO, District.class);
    }
}
