package org.example.regionkommunef24b.controller;

import org.example.regionkommunef24b.model.Kommune;
import org.example.regionkommunef24b.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KommunePageRestController {

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("kommunepage")
    public ResponseEntity<List<Kommune>> getKommunepage() {
        int page = 4;
        int size = 5;
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Kommune> pagKom = kommuneRepository.findAll(pageRequest);
        List<Kommune> komList = pagKom.getContent();
        return new ResponseEntity<>(komList, HttpStatus.OK);
    }


    @GetMapping("/kommunepageparm")
    public ResponseEntity<Map<String, Object>> getKommunepageparm(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable paging = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "navn"));
        Page<Kommune> pageKommune= kommuneRepository.findAll(paging);
        List<Kommune> kommuner = pageKommune.getContent();
        if (kommuner.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Map<String, Object> response = new HashMap<>();
        response.put("kommuner", kommuner);
        response.put("currentPage", pageKommune.getNumber());
        response.put("totalItems", pageKommune.getTotalElements());
        response.put("totalPages", pageKommune.getTotalPages());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
