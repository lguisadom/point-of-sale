package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.District;
import com.cosodi.pos.exception.ModelNotFoundException;
import com.cosodi.pos.repository.IDistrictRepository;
import com.cosodi.pos.repository.IGenderRepository;
import com.cosodi.pos.service.IDistrictService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DistrictServiceImplTest {
    @Mock
    private IDistrictRepository iDistrictRepository;

    @Autowired
    private IDistrictService iDistrictService;
    @Autowired
    private IGenderRepository iGenderRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        iDistrictService = new DistrictServiceImpl(iDistrictRepository);
    }

    @Test
    public void testFindAll() {
        List<District> districtList = Arrays.asList(
                new District(1L, "MIRAFLORES"),
                new District(2L, "SURCO")
        );

        Mockito.when(iDistrictRepository.findAll()).thenReturn(districtList);

        List<District> districtListResult = iDistrictService.findAll();

        Assertions.assertEquals(districtList, districtListResult);
        Assertions.assertEquals(2, districtListResult.size());
        Mockito.verify(iDistrictRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        District district = new District(id, "MIRAFLORES");
        Mockito.when(iDistrictRepository.findById(id)).thenReturn(Optional.of(district));

        District districtResult = iDistrictService.findById(id);

        Assertions.assertEquals(district, districtResult);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testFindById_NotFound() {
        Long id = 1L;
        Mockito.when(iDistrictRepository.findById(id)).thenReturn(Optional.empty());

        ModelNotFoundException exception = Assertions.assertThrows(ModelNotFoundException.class, () -> {
           iDistrictService.findById(id);
        });

        String expectedMessage = "ID NOT FOUND: " + id;
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testSave() {
        District districtToSave = new District();
        districtToSave.setDescription("CERCADO");

        District savedDistrict = new District(1L, "CERCADO");
        Mockito.when(iDistrictRepository.save(districtToSave)).thenReturn(savedDistrict);

        District districtResult = iDistrictService.save(districtToSave);

        Assertions.assertEquals(savedDistrict, districtResult);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).save(districtToSave);
    }

    @Test
    public void testUpdate() {
        Long id = 1L;
        District districtToUpdate = new District(id, "CERCADO");
        District updatedDistrict = new District(id, "CERCADO DE LIMA");

        Mockito.when(iDistrictRepository.findById(id)).thenReturn(Optional.of(districtToUpdate));
        Mockito.when(iDistrictRepository.save(updatedDistrict)).thenReturn(updatedDistrict);

        District districtResult = iDistrictService.update(updatedDistrict, id);

        Assertions.assertEquals(districtResult, updatedDistrict);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).findById(id);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).save(updatedDistrict);
    }

    @Test
    public void testUpdate_NotFound() {
        Long id = 1L;
        District updatedDistrict = new District(id, "CERCADO DE LIMA");

        Mockito.when(iDistrictRepository.findById(id)).thenReturn(Optional.empty());

        ModelNotFoundException exception = Assertions.assertThrows(ModelNotFoundException.class, () -> {
            iDistrictService.update(updatedDistrict, id);
        });

        String expectedMessage = "ID NOT FOUND: " + id;
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).findById(id);
        Mockito.verify(iDistrictRepository, Mockito.times(0)).save(updatedDistrict);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        District existingDistrict = new District(id, "CERCADO");

        Mockito.when(iDistrictRepository.findById(id)).thenReturn(Optional.of(existingDistrict));
        Mockito.doNothing().when(iDistrictRepository).deleteById(id);

        iDistrictService.deleteById(id);

        Mockito.verify(iDistrictRepository, Mockito.times(1)).findById(id);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void testDeleteById_NotFound() {
        Long id = 1L;

        Mockito.when(iDistrictRepository.findById(id)).thenReturn(Optional.empty());

        ModelNotFoundException exception = Assertions.assertThrows(ModelNotFoundException.class, () -> {
            iDistrictService.deleteById(id);
        });

        String expectedMessage = "ID NOT FOUND: " + id;
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
        Mockito.verify(iDistrictRepository, Mockito.times(1)).findById(id);
    }
}
