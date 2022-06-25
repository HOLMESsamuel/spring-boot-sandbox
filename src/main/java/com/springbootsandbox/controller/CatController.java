package com.springbootsandbox.controller;

import com.springbootsandbox.entity.Cat;
import com.springbootsandbox.service.CatService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatController {

    private final CatService catService;

    private final Counter counter;

    @Autowired
    public CatController(CatService catService, MeterRegistry meterRegistry) {
        this.catService = catService;
        //create a counter named "catgetter.counter" accessible on /actuator/metrics/catgetter.counter
        this.counter = meterRegistry.counter("catgetter.counter");
    }


    @GetMapping("/cats")
    public List<Cat> getCats() {
        return catService.getAllCats();
    }

    @GetMapping("/cats/{id}")
    public Cat getCat(@PathVariable Long id)
    {
        counter.increment();
        return catService.getCat(id);
    }
}
