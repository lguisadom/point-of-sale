package com.cosodi.pos.controller;

import com.cosodi.pos.dto.SaleDTO;
import com.cosodi.pos.entity.Sale;
import com.cosodi.pos.service.ISaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {
    private final ISaleService iSaleService;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SaleDTO saleDTO) {
        // return new ResponseEntity<>(this.convertToDTO(this.iSaleService.saveTransactional(this.convertToEntity(saleDTO))), HttpStatus.OK);
        Sale createdSale = this.iSaleService.save(this.convertToEntity(saleDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdSale.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    public Sale convertToEntity(SaleDTO saleDTO) {
        return modelMapper.map(saleDTO, Sale.class);
    }

    public SaleDTO convertToDTO(Sale sale) {
        return modelMapper.map(sale, SaleDTO.class);
    }
}
