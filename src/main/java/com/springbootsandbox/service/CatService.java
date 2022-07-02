package com.springbootsandbox.service;

import com.springbootsandbox.entity.Cat;
import com.springbootsandbox.repository.CatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatService {

    private CatRepository catRepository;

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Cat getCat(Long id) {
        return catRepository.findById(id).orElse(null);
    }
}
