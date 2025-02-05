package org.example.regionkommunef24b.service;

import org.example.regionkommunef24b.model.Region;
import org.example.regionkommunef24b.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceRegionerImpl implements ApiServiceGetRegioner {

    private RestTemplate restTemplate;
    public ApiServiceRegionerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    @Autowired
    RegionRepository regionRepository;

    private void saveRegioner(List<Region> regioner) {
        regioner.forEach(reg -> regionRepository.save(reg));
    }

    @Override
    public List<Region> getRegioner() {
        List<Region> lst = new ArrayList<>();
        ResponseEntity<List<Region>> regionResponse =
                restTemplate.exchange(regionUrl,
                        HttpMethod.GET, null, new      ParameterizedTypeReference<List<Region>>(){
                        });
        List<Region> regioner = regionResponse.getBody();
        saveRegioner(regioner);
        return regioner;
    }




}
