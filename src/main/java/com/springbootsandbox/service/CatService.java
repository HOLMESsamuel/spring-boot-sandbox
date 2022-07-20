package com.springbootsandbox.service;

import com.springbootsandbox.entity.Cat;
import com.springbootsandbox.repository.CatRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CatService {

    private CatRepository catRepository;

    public List<Cat> getAllCats() {
        log.info("getting cats");
        return catRepository.findAll();
    }

    public Cat getCat(Long id) {
        return catRepository.findById(id).orElse(null);
    }
}
