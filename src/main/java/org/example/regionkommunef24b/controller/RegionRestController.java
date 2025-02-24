package org.example.regionkommunef24b.controller;

import org.example.regionkommunef24b.model.Region;
import org.example.regionkommunef24b.repository.RegionRepository;
import org.example.regionkommunef24b.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class RegionRestController {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    RegionService regionService;

    @GetMapping("/regioner")
    public List<Region> getRegioner() {
        return regionRepository.findAll();
    }

    @PostMapping("/region")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postRegion(@RequestBody Region region) {
        System.out.println(region);
        return regionRepository.save(region);
    }

    @PostMapping("/region2")
    public ResponseEntity<String> postRegion2(@RequestParam String kode, @RequestParam String navn) {
        return ResponseEntity.ok("Received kode: " + kode + ", navn: " + navn);
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
