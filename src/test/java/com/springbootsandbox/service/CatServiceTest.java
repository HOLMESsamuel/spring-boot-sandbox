package com.springbootsandbox.service;

import com.springbootsandbox.entity.Cat;
import com.springbootsandbox.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CatServiceTest {

    @Mock
    private CatRepository catRepository;

    @InjectMocks
    private CatService catService;

    @Test
    void getAllCats() {
        String name = "Razmo";
        Mockito.when(catRepository.findAll())
                .thenReturn(
                        List.of(
                                new Cat(1L, name, 2),
                                new Cat(1L, name, 2)
                        )
                );

        List<Cat> result = catService.getAllCats();

        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertEquals(name, result.get(0).getName())
        );
    }

    @Test
    void getCat() {
        String name = "Razmo";
        Mockito.when(catRepository.findById(1L))
                .thenReturn(Optional.of(new Cat(1L, name, 2)));

        Cat result = catService.getCat(1L);

        assertEquals(name, result.getName());
    }

    @Test
    void getCat_case_null() {
        Mockito.when(catRepository.findById(1L)).thenReturn(Optional.empty());

        Cat result = catService.getCat(1L);

        assertNull(result);
    }
}