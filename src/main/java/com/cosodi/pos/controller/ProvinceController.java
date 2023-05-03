package com.cosodi.pos.controller;

import com.cosodi.pos.dto.ProvinceDTO;
import com.cosodi.pos.entity.Province;
import com.cosodi.pos.service.IProvinceService;
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
@RequestMapping("/api/v1/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final IProvinceService iProvinceService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ProvinceDTO>> findAll() {
        List<ProvinceDTO> provinceDTOList = this.iProvinceService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(provinceDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinceDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.convertToDTO(this.iProvinceService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProvinceDTO provinceDTO) {
        Province createdProvince = this.iProvinceService.save(this.convertToEntity(provinceDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdProvince.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvinceDTO> update(@PathVariable("id") Long id, @Valid @RequestBody ProvinceDTO provinceDTO) {
        provinceDTO.setId(id);
        return new ResponseEntity<>(this.convertToDTO(this.iProvinceService.update(this.convertToEntity(provinceDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.iProvinceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ProvinceDTO convertToDTO(Province province) {
        return this.modelMapper.map(province, ProvinceDTO.class);
    }

    public Province convertToEntity(ProvinceDTO provinceDTO) {
        return this.modelMapper.map(provinceDTO, Province.class);
    }
}
