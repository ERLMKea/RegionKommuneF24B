package org.example.regionkommunef24b.controller;

import org.example.regionkommunef24b.model.Kommune;
import org.example.regionkommunef24b.model.Region;
import org.example.regionkommunef24b.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class KommuneRestController {

    @Autowired
    KommuneRepository kommuneRepository;


    @GetMapping("/kommuner")
    public List<Kommune> getKommuner() {
        return kommuneRepository.findAll();
    }

    @GetMapping("kommune/{kode}")
    public ResponseEntity<Kommune> getKommune(@PathVariable String kode) {
        Optional<Kommune> kommune = kommuneRepository.findById(kode);
        if (kommune.isPresent()) {
            return ResponseEntity.ok(kommune.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("kommune/{kode}")
    public void deleteKommune(@PathVariable String kode) {
        System.out.println("slet kode=" + kode);
        kommuneRepository.deleteById(kode);
    }

}
