package com.cosodi.pos.service.impl;

import com.cosodi.pos.entity.Gender;
import com.cosodi.pos.exception.ModelNotFoundException;
import com.cosodi.pos.repository.IGenderRepository;
import com.cosodi.pos.service.IGenderService;
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
public class GenderServiceImplTest {
    @Mock
    private IGenderRepository iGenderRepository;

    @Autowired
    private IGenderService iGenderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        iGenderService = new GenderServiceImpl(iGenderRepository);
    }

    @Test
    public void testFindAll() {
        List<Gender> genderList = Arrays.asList(
            new Gender(1, "MASCULINO"),
            new Gender(2, "FEMENINO"),
            new Gender(3, "OTRO")
        );

        Mockito.when(iGenderRepository.findAll()).thenReturn(genderList);

        List<Gender> genderListResult = iGenderService.findAll();

        Assertions.assertEquals(genderList, genderListResult);
        Assertions.assertEquals(3, genderListResult.size());
        Mockito.verify(iGenderRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Integer id = 1;
        Gender gender = new Gender(id, "OTRO");
        Mockito.when(iGenderRepository.findById(id)).thenReturn(Optional.of(gender));

        Gender genderResult = iGenderService.findById(id);

        Assertions.assertEquals(gender, genderResult);
        Mockito.verify(iGenderRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testFindById_NotFound() {
        Integer id = 1;
        Mockito.when(iGenderRepository.findById(id)).thenReturn(Optional.empty());

        ModelNotFoundException exception = Assertions.assertThrows(ModelNotFoundException.class, () -> {
            iGenderService.findById(id);
        });

        String expectedMessage = "ID NOT FOUND: " + id;
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
        Mockito.verify(iGenderRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testSave() {
        Gender genderToSave = new Gender();
        genderToSave.setName("FEMENINO");

        Gender savedGender = new Gender(1, "FEMENINO");
        Mockito.when(iGenderRepository.save(genderToSave)).thenReturn(savedGender);

        Gender genderResult = iGenderService.save(genderToSave);

        Assertions.assertEquals(savedGender, genderResult);
        Mockito.verify(iGenderRepository, Mockito.times(1)).save(genderToSave);
    }

    @Test
    public void testUpdate() {
        Integer id = 1;
        Gender genderToUpdate = new Gender(id, "FEMENINO");
        Gender updatedGender = new Gender(id, "FEMENINO2");

        Mockito.when(iGenderRepository.findById(id)).thenReturn(Optional.of(genderToUpdate));
        Mockito.when(iGenderRepository.save(updatedGender)).thenReturn(updatedGender);

        Gender genderResult = iGenderService.update(updatedGender, id);

        Assertions.assertEquals(genderResult, updatedGender);
        Mockito.verify(iGenderRepository, Mockito.times(1)).findById(id);
        Mockito.verify(iGenderRepository, Mockito.times(1)).save(updatedGender);
    }

    @Test
    public void testUpdate_NotFound() {
        Integer id = 1;
        Gender updatedGender = new Gender(id, "FEMENINO");

        Mockito.when(iGenderRepository.findById(id)).thenReturn(Optional.empty());

        ModelNotFoundException exception = Assertions.assertThrows(ModelNotFoundException.class, () -> {
            iGenderService.update(updatedGender, id);
        });

        String expectedMessage = "ID NOT FOUND: " + id;
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
        Mockito.verify(iGenderRepository, Mockito.times(1)).findById(id);
        Mockito.verify(iGenderRepository, Mockito.times(0)).save(updatedGender);
    }

    @Test
    public void testDeleteById() {
        Integer id = 1;
        Gender existingGender = new Gender(id, "FEMENINO");

        Mockito.when(iGenderRepository.findById(id)).thenReturn(Optional.of(existingGender));
        Mockito.doNothing().when(iGenderRepository).deleteById(id);

        iGenderService.deleteById(id);

        Mockito.verify(iGenderRepository, Mockito.times(1)).findById(id);
        Mockito.verify(iGenderRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void testDeleteById_NotFound() {
        Integer id = 1;

        Mockito.when(iGenderRepository.findById(id)).thenReturn(Optional.empty());

        ModelNotFoundException exception = Assertions.assertThrows(ModelNotFoundException.class, () -> {
            iGenderService.deleteById(id);
        });

        String expectedMessage = "ID NOT FOUND: " + id;
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
        Mockito.verify(iGenderRepository, Mockito.times(1)).findById(id);
    }
}
