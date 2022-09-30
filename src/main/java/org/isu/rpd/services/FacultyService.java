package org.isu.rpd.services;

import org.isu.rpd.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.isu.rpd.repositories.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository repository;
    public List<Faculty> findAll(){
        return repository.findAll();
    }
    public Faculty findById(int id){
        return repository.findById(id);
    }
}
