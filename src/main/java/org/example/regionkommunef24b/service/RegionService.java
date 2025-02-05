package org.example.regionkommunef24b.service;

import org.example.regionkommunef24b.model.Region;
import org.example.regionkommunef24b.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<String> kommuneNavne(String regionKode) {
        List<String> lstNavne = new ArrayList<String>();
        Optional<Region> regionOpt = regionRepository.findById(regionKode);
        if (regionOpt.isPresent()) {
            Region region = regionOpt.get();
            lstNavne = region.getKommuner().stream().map(k -> k.getNavn()).sorted().toList();
            return lstNavne;
        } else {
            return lstNavne;
        }
    }

}
