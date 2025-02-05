package org.example.regionkommunef24b.service;

import org.example.regionkommunef24b.model.Kommune;
import org.example.regionkommunef24b.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {

    private RestTemplate restTemplate;
    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String KommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;

    private void saveKommuner(List<Kommune> Kommuneer) {
        Kommuneer.forEach(reg -> kommuneRepository.save(reg));
    }

    @Override
    public List<Kommune> getKommuner() {
        ResponseEntity<List<Kommune>> KommuneResponse =
                restTemplate.exchange(KommuneUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>(){
                        });
        List<Kommune> Kommuneer = KommuneResponse.getBody();
        saveKommuner(Kommuneer);
        return Kommuneer;
    }



}
