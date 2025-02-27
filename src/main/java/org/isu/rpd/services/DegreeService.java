package org.isu.rpd.services;

import org.isu.rpd.model.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.isu.rpd.repositories.DegreeRepository;

import java.util.List;

@Service
public class DegreeService {
    @Autowired
    DegreeRepository repository;
    public List<Degree> findAll(){
        return repository.findAll();
    }
    public Degree findById(int id){
        return repository.findById(id);
    }
}
