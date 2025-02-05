package org.example.regionkommunef24b.controller;

import org.example.regionkommunef24b.model.Region;
import org.example.regionkommunef24b.repository.RegionRepository;
import org.example.regionkommunef24b.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionRestController {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    RegionService regionService;

    @GetMapping("/regioner")
    public List<Region> getRegioner() {
        return regionRepository.findAll();
    }

    @DeleteMapping("region/{kode}")
    public void deleteRegion(@PathVariable String kode) {
        System.out.println("slet kode=" + kode);
        regionRepository.deleteById(kode);
    }

    @GetMapping("region/{kode}")
    public ResponseEntity<Region> getRegion(@PathVariable String kode) {
        Optional<Region> region = regionRepository.findById(kode);
        if (region.isPresent()) {
            return ResponseEntity.ok(region.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/kommunenavne/{kode}")
    public List<String> getKommunenavne(@PathVariable String kode) {
        return regionService.kommuneNavne(kode);
    }

}
