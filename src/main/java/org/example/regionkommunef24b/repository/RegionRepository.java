package org.example.regionkommunef24b.repository;

import org.example.regionkommunef24b.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region,String> {

    Optional<Region> findByNavn(String name);

}

