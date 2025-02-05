package org.example.regionkommunef24b.controller;

import org.example.regionkommunef24b.model.Region;
import org.example.regionkommunef24b.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/regioner")
    public List<Region> getRegioner() {
        return regionRepository.findAll();
    }

}
