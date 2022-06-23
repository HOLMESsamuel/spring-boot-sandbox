package com.springbootsandbox.controller;

import com.springbootsandbox.entity.Cat;
import com.springbootsandbox.service.CatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CatController {

    private CatService catService;

    @GetMapping("/cats")
    public List<Cat> getCats() {
        return catService.getAllCats();
    }

    @GetMapping("/cats/{id}")
    public Cat getCat(@PathVariable Long id) {
        return catService.getCat(id);
    }
}
