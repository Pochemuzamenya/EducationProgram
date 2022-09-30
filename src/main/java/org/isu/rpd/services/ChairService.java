package org.isu.rpd.services;

import org.isu.rpd.model.Chair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.isu.rpd.repositories.ChairRepository;

import java.util.List;

@Service
public class ChairService {
    @Autowired
    ChairRepository repository;
    public List<Chair> findAll(){
        return repository.findAll();
    }

    public Chair findById(int chair_id) {
        return repository.findById(chair_id);
    }
}
