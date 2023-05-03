package com.cosodi.pos.controller;

import com.cosodi.pos.dto.DepartmentDTO;
import com.cosodi.pos.entity.Department;
import com.cosodi.pos.service.IDepartmentService;
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
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService iDepartmentService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        List<DepartmentDTO> departmentDTOList = this.iDepartmentService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(departmentDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.convertToDTO(this.iDepartmentService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody DepartmentDTO departmentDTO) {
        Department createdDepartment = this.iDepartmentService.save(this.convertToEntity(departmentDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDepartment.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> update(@PathVariable("id") Long id, @Valid @RequestBody DepartmentDTO departmentDTO) {
        departmentDTO.setId(id);
        return new ResponseEntity<>(this.convertToDTO(this.iDepartmentService.update(this.convertToEntity(departmentDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.iDepartmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public DepartmentDTO convertToDTO(Department department) {
        return this.modelMapper.map(department, DepartmentDTO.class);
    }

    public Department convertToEntity(DepartmentDTO departmentDTO) {
        return this.modelMapper.map(departmentDTO, Department.class);
    }
}
