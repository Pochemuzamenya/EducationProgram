package org.isu.rpd.services;

import org.isu.rpd.model.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.isu.rpd.repositories.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyService {

    @Autowired
    SpecialtyRepository repository;
    public List<Specialty> findAll() {
        return repository.findAll();
    }

    public Specialty findById(int id) {
        return repository.findById(id);
    }

    public void save(Specialty specialty) {
        repository.saveAndFlush(specialty);
    }
}
